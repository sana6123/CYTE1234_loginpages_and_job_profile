package com.example.cytelogin;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
public class DetailsActivity extends AppCompatActivity{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<HashMap<String, String>> jobList = db.GetJobs();
        ListView lv = findViewById(R.id.jobList);
        ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, jobList, R.layout.list_row, new String[]{"name", "designation", "location"}, new int[]{R.id.name, R.id.designation, R.id.location});
        lv.setAdapter(adapter);
            }
        }

