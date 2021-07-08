package com.android.uniinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class university_info extends AppCompatActivity {
    TextView uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_info);

        int value = getIntent().getIntExtra("pos",0);
        uname = findViewById(R.id.uName);
        Toast.makeText(university_info.this,"you click " + value,Toast.LENGTH_LONG).show();

    }

}