package com.example.cytelogin;

//import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity_jobs extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper myDb;
    Intent intent;
    //public ArrayList <Jobposts> posts;
    ListView jobList;
    JobpostsCursorAdapter jobpostsCursorAdapter;

    private TextView title;
    private ImageButton speakButton;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jobs);

        speakButton = findViewById(R.id.speechButton);
        //if speakButton clicked, call method askSpeechInput
        speakButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                askSpeechInput();
            }
        });





        //create a new instance/database
        myDb = new DatabaseHelper(getApplicationContext());
        // Button searchPosts = findViewById(R.id.Search_posts);
        title = findViewById(R.id.titleEdit);
        //final ArrayList <Jobposts> posts = new ArrayList <Jobposts> ();




        ArrayList<HashMap<String, String>> userList = myDb.GetJobs();
        ListView lv = (ListView) findViewById(R.id.jobList);
        ListAdapter adapter = new SimpleAdapter(MainActivity_jobs.this, userList, R.layout.list_row, new String[]{"name", "designation", "location"}, new int[]{R.id.name, R.id.designation, R.id.location});
        lv.setAdapter(adapter);



        final Spinner spinner =findViewById(R.id.spinnerIndustry);

        // Create an ArrayAdapter using a string array and a specified spinner layout
        ArrayAdapter<CharSequence> industryAdapter = ArrayAdapter.createFromResource(this, R.array.industry_array, R.layout.spinner_text_colour);

        //Specify the layout to use when the list of choices appears
        industryAdapter.setDropDownViewResource(R.layout.spinner_dropdown_colour);

        //Apply adapter to the spinner
        spinner.setAdapter(industryAdapter);


        final Spinner spinner2 = findViewById(R.id.spinnerCity);
        // Create an ArrayAdapter using a string array and a specified spinner layout
        ArrayAdapter<CharSequence> cityAdapter = ArrayAdapter.createFromResource(this, R.array.city_array, R.layout.spinner_text_colour);
        //Specify the layout to use when the list of choices appears
        cityAdapter.setDropDownViewResource(R.layout.spinner_dropdown_colour);
        //Apply adapter to the spinner
        spinner2.setAdapter(cityAdapter);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);


        final Button searchPosts = findViewById(R.id.Search_posts);

      /*  searchPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                String selectedIndustry = spinner.getSelectedItem().toString();
                String selectedCity = spinner2.getSelectedItem().toString();
                String titleText = title.getText().toString();

                cursor = myDb.getAllApplications(titleText, selectedIndustry, selectedCity);
                //jobpostsCursorAdapter = new JobpostsCursorAdapter(getApplicationContext(),cursor);
                //jobList.setAdapter(jobpostsCursorAdapter);


                //startActivity(new Intent(MainActivity_jobs.this, job_profile.class));


                Intent intent = new Intent(getApplicationContext(), job_profile.class);
                startActivity(intent);

            }
        });*/

//create an activity with the linear layout to call search posts, follow spaceship example

//something I added this weekend
        //Toast.makeText(getApplicationContext(), "New post is stored", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    // Showing google speech input dialog
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    // Receiving speech input
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    title.setText(result.get(0));
                }
                break;
            }

        }
    }

}
//cut it out later
/*for (int i = 0; i < posts.size(); i++) {
                    Jobposts sa = posts.get(i);
                    TextView t = new TextView(getApplicationContext());
                    t.setText(sa.toString());
                    final int update_id = sa.getId();
                    runOnUiThread(run);
                    t.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Intent intent = new Intent(getApplicationContext(), Assessment1.class);
                            intent.putExtra("id", update_id);
                            startActivity(intent);
                        }});
                    jobPostlist.addView(t);
                }
// what is the Joblist from database then?
                jobPostlist.postInvalidate();*/