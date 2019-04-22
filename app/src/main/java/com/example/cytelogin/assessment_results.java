package com.example.cytelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class assessment_results extends AppCompatActivity {

    //initialize variables
    int score;
    int questionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assessment_results);


        String MyPrefs = "Assessment";
        SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        //get score and question number data from shared preferences
        score = sharedpreferences.getInt("score",0);
        questionNum = sharedpreferences.getInt("questionNum",1);

        //call method onRun
        onRun();
    }

    public void onRun() {
        TextView result = findViewById(R.id.score);
        Button linksToEdu = findViewById(R.id.links_to_edu);
        Button backToPosts = findViewById(R.id.back_to_posts);

        //find the score as a percentage
        float temp = (float) score / (float) questionNum;
        int finalScore = (int) (temp * (float) 100);

        //print the score in the textview
        result.setText(String.format(Locale.CANADA, "Score: %d%%", finalScore));

        //if the final score is less than 75%, show both links to education button and back to job posts button
        //if the final score is more than 75%, show only the back to job posts button
        if (finalScore<75){
            linksToEdu.setVisibility(View.VISIBLE);
            backToPosts.setVisibility(View.VISIBLE);
        } else {
            linksToEdu.setVisibility(View.GONE);
            backToPosts.setVisibility(View.VISIBLE);
        }

        //when links to education button clicked
        linksToEdu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create intent to switch to links to education activity
                Intent intent = new Intent(getApplicationContext(), links_to_education.class);
                startActivity(intent);
            }
        });

        //when back to job posts button clicked
        backToPosts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create intent to switch to back to job posts activity
                Intent intent = new Intent(getApplicationContext(), MainActivity_jobs.class);
                startActivity(intent);
            }
        });
        }
}
