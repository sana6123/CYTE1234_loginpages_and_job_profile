package com.example.cytelogin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class JobpostsCursorAdapter extends CursorAdapter {
    public JobpostsCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.sample_job_posts_list_view_components, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView AdapterTitleText = (TextView) view.findViewById(R.id.AdapterTitleText);
        TextView AdapterIndustryText = (TextView) view.findViewById(R.id.AdapterIndustryText);
        TextView AdapterCityText = (TextView) view.findViewById(R.id.AdapterCityText);

        // Extract properties from cursor
        String CursorTitle = cursor.getString(cursor.getColumnIndexOrThrow("TITLE"));
        String CursorIndustry = cursor.getString(cursor.getColumnIndexOrThrow("INDUSTRY"));
        String CursorCity = cursor.getString(cursor.getColumnIndexOrThrow("CITY"));
        // Populate fields with extracted properties
        AdapterTitleText.setText(CursorTitle);
        AdapterIndustryText.setText(CursorIndustry);
        AdapterCityText.setText(CursorCity);
    }
}

