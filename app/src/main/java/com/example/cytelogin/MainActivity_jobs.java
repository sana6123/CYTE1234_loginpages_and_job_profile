package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity_jobs extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jobs);
        //create a new instance/database
        myDb = new DatabaseHelper(this);
        Button searchPosts = findViewById(R.id.Search_posts);
        final EditText title = findViewById(R.id.titleEdit);
        final LinearLayout jobPostlist = findViewById(R.id.jobList);

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerIndustry);
        // Create an ArrayAdapter using a string array and a default spinner layout
            ArrayAdapter<CharSequence> industryAdapter = ArrayAdapter.createFromResource(this,R.array.industry_array, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        industryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to the spinner
        spinner.setAdapter(industryAdapter);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinnerCity);
        // Create an ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this,R.array.city_array, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to the spinner
        spinner2.setAdapter(cityAdapter);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        searchPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedIndustry = spinner.getSelectedItem().toString();
                String selectedCity = spinner2.getSelectedItem().toString();
                String titleText = title.getText().toString();

                ArrayList<Jobposts> posts =  myDb.getAllApplications(titleText, selectedIndustry, selectedCity);

                for (int i = 0; i < posts.size(); i++) {
                    Jobposts sa = posts.get(i);
                    TextView t = new TextView(getApplicationContext());
                    t.setText(sa.toString());
                    final int update_id = sa.getId();
                    t.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Assessment1.class);
                            intent.putExtra("id", update_id);
                            startActivity(intent);
                        }});
                    jobPostlist.addView(t);
                }
// what is the Joblist from database then?
                jobPostlist.postInvalidate();
            }
        });

//create an activity with the linear layout to call search posts, follow spaceship example

//something I added this weekend
        //Toast.makeText(getApplicationContext(), "New post is stored", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



