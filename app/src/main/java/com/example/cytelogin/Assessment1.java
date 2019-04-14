package com.example.cytelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Assessment1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessmenttest);

        createRadioButtons();
    }

    private void createRadioButtons (){
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

        //get items from assessment_array
        String [] answerChoices = getResources().getStringArray(R.array.assessment_array);

        ArrayList<String> arrayText = new ArrayList<>();
        Collections.addAll(arrayText, answerChoices);

        //get number of views (radio buttons) within the radiogroup
        final int childCount = group_assessment.getChildCount();


        for (int x=0; x<childCount; x++) {
            //set text of radiobuttons to text in assessment_array
            RadioButton rb = (RadioButton) group_assessment.getChildAt(x);
            rb.setText(arrayText.get(x));

            /* String ansChoice = answerChoices[x];

            RadioButton ans1 = new RadioButton(this);
            ans1.setText(string);



             //TODO: Set on-click callbacks

            //Add to radio group
            group_assessment.addView(ans1);*/
        }

    }

}


