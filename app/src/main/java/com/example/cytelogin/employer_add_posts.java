package com.example.cytelogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class employer_add_posts extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper myDb;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String NEXT_ID = "ID_Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_add_posts);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        myDb = new DatabaseHelper(this);
        Button posts = findViewById(R.id.post);
        final EditText title = findViewById(R.id.createTitle);

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


        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String createIndustry = spinner.getSelectedItem().toString();
                String createCity = spinner2.getSelectedItem().toString();
                String createTitle = title.getText().toString();
                int id = sharedpreferences.getInt(NEXT_ID, 0); //K4
                SharedPreferences.Editor editor = sharedpreferences.edit(); //K5
                editor.putInt(NEXT_ID, id+1);
                editor.commit();

                myDb.insertData(id, createTitle, createIndustry, createCity);
                myDb.close();
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
