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
        goToUrl ( "https://www.pluralsight.com/browse/software-development");
    }

    public void goto2 (View view) {
        goToUrl ( "https://teamtreehouse.com/");
    }
    public void goto3 (View view) {
        goToUrl ( "https://www.codecademy.com/");
    }
    public void goto11 (View view) {
        goToUrl ( "https://ca.trustpilot.com/review/pluralsight.com");
    }

    public void goto22 (View view) {
        goToUrl ( "https://www.switchup.org/bootcamps/treehouse");
    }
    public void goto33 (View view) {
        goToUrl ( "https://www.switchup.org/bootcamps/codecademy");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}


