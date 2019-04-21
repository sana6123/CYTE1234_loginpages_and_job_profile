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

        final Button SubmitAssessmenmt =(Button) findViewById(R.id.Submit_assessment);

        SubmitAssessmenmt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }});

    }
}
