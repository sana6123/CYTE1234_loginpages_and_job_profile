package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makeAssessment_employer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_assessment_employer);

        final Button submitAssessment = findViewById(R.id.Submit_assessment);

        //if button submitAssessment clicked
        submitAssessment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //creates new intent, switches activity to MainActivity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }});

    }
}
