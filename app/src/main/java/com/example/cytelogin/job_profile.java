package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class job_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_profile);

        final Button GoToAssessment = findViewById(R.id.assessmentButton);

        //if GoToAssessment button clicked
        GoToAssessment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //switch activity to skill_test
                Intent intent = new Intent(getApplicationContext(), skill_Test.class);
                startActivity(intent);


            }


        });
    }
}

