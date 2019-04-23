package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.net.Uri;


public class links_to_education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_to_education);

        final Button toJobs = findViewById(R.id.Job_Posts);

        //if button toJobs clicked
        toJobs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //create new intent, switch activity to MainAcitivity_jobs
                Intent intent = new Intent(getApplicationContext(), MainActivity_jobs.class);
                startActivity(intent);
            }
        });

    }
//this link takes the user to BowValley software developing course that they offer
    public void goto1 (View view) {
        goToUrl ( "https://bowvalleycollege.ca/programs-courses/creative-technologies/software-development");
    }
    //this link takes the user to Sait programs and courses regarding java
    public void goto2 (View view) {
        goToUrl ( "https://www.sait.ca/programs-and-courses/continuing-education/courses-and-certificates/java-development-certificate-of-achievemen");
    }
    //this link takes the user to Ontariocolleges to go through an analyst programming course that they offer
    public void goto3 (View view) {
        goToUrl ( "https://www.ontariocolleges.ca/en/programs/computers-and-telecommunications/computer-programmer-analyst");
    }
    //this link takes the user to student Reviews for BowValley collage
    public void goto11 (View view) {
        goToUrl ( "http://www.ratemyprofessors.com/campusRatings.jsp?sid=5635");
    }
    //this link takes the user to reviews for Sait Institute of Technology
    public void goto22 (View view) {
        goToUrl ( "https://www.sait.ca/about-sait/who-we-are/publications/graduate-employment-survey");
    }
    //this link takes the user to reviews for Onatariocollages
    public void goto33 (View view) {
        goToUrl ( "https://www.facebook.com/pg/ontariocolleges.ca/reviews/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);

        //creates new intent, launches the link specified above
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}


