package com.example.cytelogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;

public class Assessment1 extends AppCompatActivity {

    //  SharedPreferences myprefs;

    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessmenttest);

        // myprefs = getPreferences(MODE_PRIVATE);

        createRadioButtons();
        onSubmit();

    }


    private void createRadioButtons (){
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

        //get items from answer_array1
        String [] answerChoices = getResources().getStringArray(R.array.answer_array1);

        ArrayList<String> arrayText = new ArrayList<>();
        Collections.addAll(arrayText, answerChoices);

        //get number of views (radio buttons) within the radiogroup
        final int childCount = group_assessment.getChildCount();


        for (int x=0; x<childCount; x++) {
            //set text of radiobuttons to text in answer_array1
            RadioButton ans1 = (RadioButton) group_assessment.getChildAt(x);
            ans1.setText(arrayText.get(x));


            //TODO: NEED THIS??
            final String ansChoice = answerChoices[x];

            //TODO: Set on-click callbacks
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(Assessment1.this, "Clicked" + ansChoice, Toast.LENGTH_SHORT).show();

                }
            });


            //TODO: NEED THIS??
            //Add to radio group
            //group_assessment.addView(ans1);
        }

    }

    private void onSubmit(){
        Button submit_assessment = findViewById(R.id.submit_assess);
        submit_assessment.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

                //retrieve information of what button selected
                int idSelected = group_assessment.getCheckedRadioButtonId();
                RadioButton ans1 = findViewById(idSelected);
                String userChoice = ans1.getText().toString();

                //retrieve items from array
                String[] correctans = getResources().getStringArray(R.array.correct_answers);
                ArrayList<String> arrayText = new ArrayList<>();
                Collections.addAll(arrayText, correctans);

                //takes ans from array
                for (int x = 0; x < correctans.length; x++) {
                    ans = arrayText.get(x);

                    //check answer, compares userChoice with ans
                    if(userChoice.equals(ans)){
                        Toast.makeText(Assessment1.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Assessment1.this, "Incorrect!", Toast.LENGTH_SHORT).show();

                    }

                }
                /*
                //start sharedpreferences editor
                SharedPreferences.Editor editor = myprefs.edit();
                editor.putString("keychoice",userChoice);
                editor.commit();
*/

            }
        });

    }
/*
    public void readPreferences (){
        readPreferences();
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);
        int idSelected = group_assessment.getCheckedRadioButtonId();
        RadioButton ans1 = findViewById(idSelected);
        String userChoice = ans1.getText().toString();

        String ch1 = myprefs.getString("keychoice", "");
        ans1.setText(ch1);
        //Toast.makeText(Assessment1.this, "Chose " + ans1, Toast.LENGTH_SHORT).show();
    }*/
}


