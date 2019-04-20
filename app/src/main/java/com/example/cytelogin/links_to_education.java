package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.net.Uri;


public class links_to_education extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_to_education);

    }
    public void goto1 (View view) {
        goToUrl ( "https://bowvalleycollege.ca/programs-courses/creative-technologies/software-development");
    }

    public void goto2 (View view) {
        goToUrl ( "https://www.sait.ca/programs-and-courses/continuing-education/courses-and-certificates/java-development-certificate-of-achievemen");
    }
    public void goto3 (View view) {
        goToUrl ( "https://www.ontariocolleges.ca/en/programs/computers-and-telecommunications/computer-programmer-analyst");
    }
    public void goto11 (View view) {
        goToUrl ( "http://www.ratemyprofessors.com/campusRatings.jsp?sid=5635");
    }

    public void goto22 (View view) {
        goToUrl ( "https://www.sait.ca/about-sait/who-we-are/publications/graduate-employment-survey");
    }
    public void goto33 (View view) {
        goToUrl ( "https://www.facebook.com/pg/ontariocolleges.ca/reviews/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}


