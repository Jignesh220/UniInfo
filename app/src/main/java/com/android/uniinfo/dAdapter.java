package com.android.uniinfo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class dAdapter extends ArrayAdapter<dUniversity> {
    public dAdapter(@NonNull Context context, List<dUniversity> dUniversitys) {
        super(context, 0,dUniversitys);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.activity_university_name, parent, false);
        }

        TextView uniName = (TextView) convertView.findViewById(R.id.uName);

        dUniversity dUniversity = getItem(position);

        uniName.setVisibility(View.VISIBLE);
        uniName.setText(dUniversity.getName());

        return convertView;
    }

}
