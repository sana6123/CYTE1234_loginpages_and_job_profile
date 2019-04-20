package com.example.cytelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
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

    public static final String MyPrefs = "myprefs";
    SharedPreferences sharedpreferences;

    String correctAns;
    int questionNum=0;
    static int score=0;
    int numOfQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        sharedpreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);

        //timer
        new CountDownTimer(60000, 1000){
            TextView timerText = findViewById(R.id.timerText);

            public void onTick(long millisUntilFinished){
                timerText.setText("Time left: "+millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerText.setText("Time's up!");
                finishTest();
            }

        }.start();

        onRun();
    }

    private void onRun(){
        String[] questionArray = getResources().getStringArray(R.array.question_array);
        numOfQuestions = questionArray.length-1;


        updateQuestion();
        createQuestion();
        createRadioButtons();
        onNextQuestion();
    }

    private void createQuestion() {
        TextView questionView1 = findViewById(R.id.question1);

        //get items from question_array
        String[] questionArray = getResources().getStringArray(R.array.question_array);

        ArrayList<String> arrayText = new ArrayList<>();
        Collections.addAll(arrayText, questionArray);

        //set text of textView to text in question_array
        String question = arrayText.get(questionNum);
        questionView1.setText(question);

    }

    private void createRadioButtons (){
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);
        String [] answerChoices = {"", "", "", ""};

        //get items from answer_array1
        switch(questionNum){
            case 1:
                answerChoices = getResources().getStringArray(R.array.answer_array1);
                break;
            case 2:
                answerChoices = getResources().getStringArray(R.array.answer_array2);
                break;
            case 3:
                answerChoices = getResources().getStringArray(R.array.answer_array3);
                break;
            case 4:
                answerChoices = getResources().getStringArray(R.array.answer_array4);
        }

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

    private void onNextQuestion(){
        Button next_question = findViewById(R.id.next_question);
        next_question.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

                //retrieve information of what button selected
                int idSelected = group_assessment.getCheckedRadioButtonId();
                RadioButton ans1 = findViewById(idSelected);
                String userChoice = ans1.getText().toString();

                //retrieve items from array
                String[] ans = getResources().getStringArray(R.array.correct_answers);
                ArrayList<String> arrayText = new ArrayList<>();
                Collections.addAll(arrayText, ans);

                //takes correct ans from array
                correctAns = arrayText.get(questionNum);

                //check answer, compares userChoice with ans
                if(userChoice.equals(correctAns)){
                    Toast.makeText(Assessment1.this, "Correct!", Toast.LENGTH_SHORT).show();
                    updateScore();
                } else {
                    Toast.makeText(Assessment1.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                }

                //TODO: Change Intent to Assessment Results when created
                //TODO: Add onSubmit method to do intent and to change the button text to "Submit"
                if (questionNum==numOfQuestions){
                    score=score;
                    finishTest();
                } else {
                    group_assessment.clearCheck();
                    onRun();

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

    private void finishTest(){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("score",score);
        editor.putInt("questionNum",numOfQuestions);
        editor.commit();

        //startActivity(new Intent(Assessment1.this, assessment_results.class));
        Intent intent = new Intent(getApplicationContext(), assessment_results.class);
        startActivity(intent);

    }

    private void updateScore(){
        score++;
    }

    private void updateQuestion(){
        questionNum++;
    }



/*
    public void readPreferences (){
        readPreferences();
;

        String ch1 = myprefs.getString("keychoice", "");
        ans1.setText(ch1);
    */
}


