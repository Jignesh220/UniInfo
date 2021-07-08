package com.android.uniinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class countrySelection extends AppCompatActivity {

    ArrayList<dUniversity> dUniversities = new ArrayList<>();
    ListView listView;
    TextView textView;
    int noOfObject;
    EditText editText;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);
        listView =findViewById(R.id.list_item);
        textView = findViewById(R.id.intro);
        editText = findViewById(R.id.cCountry);
        button = findViewById(R.id.iButton);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String sCountryName = editText.getText().toString();
                if (TextUtils.isEmpty(sCountryName)){
                    Toast.makeText(countrySelection.this,"Please Enter Country Name First!!",Toast.LENGTH_LONG).show();
                    return;
                }
                closeKeyboard();
                getUniName(sCountryName);

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference store = db.collection("code").document("count");
                store.update("Count", FieldValue.increment(1));
            }
        });

        onItemClick();
    }

    private void getUniName(String coName){

        String url = "http://universities.hipolabs.com/search?country="+coName;

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.getCache().clear();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    noOfObject = response.length();
                    for (int i=0; i<response.length();i++){
                        JSONObject uniObject = response.getJSONObject(i);

                        String uniName = (i+1) +"."+uniObject.getString("name");
                        dUniversity v1 = new dUniversity(uniName);

                        dUniversities.add(v1);
                        ArrayList<dUniversity> dispUni = dUniversities;
                        dAdapter uniAdapter=new dAdapter(countrySelection.this, dispUni);
                        listView.setAdapter(uniAdapter);
                        progressBar.setVisibility(View.GONE);
                    }

                } catch (JSONException e) {
                    progressBar.setVisibility(View.GONE);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.d("appdata", "Something went wrong");
                Toast.makeText(countrySelection.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    public void onItemClick(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = position+1;
                Intent intent = new Intent(countrySelection.this,disply_info.class);

                String sCountryName = editText.getText().toString();
                Bundle mBundle = new Bundle();
                mBundle.putInt("pos",position);
                mBundle.putString("country1",sCountryName);
                intent.putExtras(mBundle);
                startActivity(intent);
            }
        });
    }

    private static long back_pressed;
    @Override
    public void onBackPressed(){
        if (back_pressed + 2000 > System.currentTimeMillis()){
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {

            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}