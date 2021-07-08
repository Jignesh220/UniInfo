package com.android.uniinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class disply_info extends AppCompatActivity {
    ListView listView2;
    int value;
    String cName1;
    ProgressBar progressBar2;
    String dWebLinks;

    ArrayList<iUniversity> iUniversities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply_info);

        listView2 = findViewById(R.id.list_item2);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.VISIBLE);

        value = getIntent().getIntExtra("pos",0);
        cName1 = getIntent().getStringExtra("country1");
        getUniName(cName1);
        onItemClick();

    }

    private void getUniName(String c1){
        String url = "http://universities.hipolabs.com/search?country=" + c1;

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                        JSONObject uniObject = response.getJSONObject(value);

                        String dUniverName =uniObject.getString("name");
                        String dcityName =uniObject.getString("state-province");
                        String  dCountryName=uniObject.getString("country");
                        dWebLinks =uniObject.getJSONArray("web_pages").getString(0);

                        iUniversity v1 = new iUniversity(dUniverName,dcityName,dCountryName,dWebLinks);

                        iUniversities.add(v1);
                        ArrayList<iUniversity> dispUniInfo = iUniversities;
                        iAdapter uniInfoAdapter=new iAdapter(disply_info.this, dispUniInfo);
                        listView2.setAdapter(uniInfoAdapter);
                        progressBar2.setVisibility(View.GONE);

                } catch (JSONException e) {
                    progressBar2.setVisibility(View.GONE);
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar2.setVisibility(View.GONE);
                Log.d("appdata", "Something went wrong");
                Toast.makeText(disply_info.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    public void onItemClick(){
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(dWebLinks));
                startActivity(i);
            }
        });
    }
}