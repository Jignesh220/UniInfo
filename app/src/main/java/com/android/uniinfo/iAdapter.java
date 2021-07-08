package com.android.uniinfo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class iAdapter extends ArrayAdapter<iUniversity> {
    public iAdapter(@NonNull Context context, List<iUniversity> iUniversitys) {
        super(context, 0,iUniversitys);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.activity_university_info, parent, false);
        }

        TextView univerName = (TextView) convertView.findViewById(R.id.universityName);
        TextView iCity = (TextView) convertView.findViewById(R.id.cityName);
        TextView iCountry = (TextView) convertView.findViewById(R.id.countryName);
        TextView iWebLink = (TextView) convertView.findViewById(R.id.webLink);

        iUniversity iUniversity = getItem(position);

        univerName.setVisibility(View.VISIBLE);
        univerName.setText(iUniversity.getUniversityName());
        iCity.setText(iUniversity.getCity());
        iCountry.setText(iUniversity.getCountry());
        iWebLink.setText(iUniversity.getWebLink());

        return convertView;
    }
}
