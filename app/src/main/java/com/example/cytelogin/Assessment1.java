package com.example.cytelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Assessment1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessmenttest);

        createRadioButtons();
        setupSubmitAssessmentButton();
    }

    private void setupSubmitAssessmentButton(){
        Button submit_assessment = findViewById(R.id.submit_assess);
        submit_assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);
                int idSelected = group_assessment.getCheckedRadioButtonId();


                RadioButton ans1 = findViewById(idSelected);
                String show = ans1.getText().toString();

                Toast.makeText(Assessment1.this, "Chose " + show, Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void createRadioButtons (){
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

        //get items from assessment_array
        String [] answerChoices = getResources().getStringArray(R.array.answer_array1);

        ArrayList<String> arrayText = new ArrayList<>();
        Collections.addAll(arrayText, answerChoices);

        //get number of views (radio buttons) within the radiogroup
        final int childCount = group_assessment.getChildCount();


        for (int x=0; x<childCount; x++) {
            //set text of radiobuttons to text in assessment_array
            RadioButton ans1 = (RadioButton) group_assessment.getChildAt(x);
            ans1.setText(arrayText.get(x));


            //TODO: NEED THIS??
            final String ansChoice = answerChoices[x];

             //TODO: Set on-click callbacks
             ans1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(Assessment1.this, "Clicked" + ansChoice, Toast.LENGTH_SHORT).show();

                 }
             });

             //TODO: NEED THIS??
            //Add to radio group
            //group_assessment.addView(ans1);
        }

    }

}


