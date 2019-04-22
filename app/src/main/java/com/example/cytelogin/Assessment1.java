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

    public static final String MyPREFERENCES = "Assessment"; //the 'folder' where the app data is saved on the phone
    SharedPreferences sharedpreferences; //The class that helps save things to the phone

    //initialize variables
    String correctAns;
    int questionNum = 0;
    static int score = 0;
    int numOfQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        //clear shared preferences
        sharedpreferences.edit().clear().apply();

        //start timer
        new CountDownTimer(60000, 1000) { //set timer for 60 secs, count down by 1 second intervals
            TextView timerText = findViewById(R.id.timerText);

            public void onTick(long millisUntilFinished) {
                timerText.setText("Time left: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                //when timer is up, shows text
                timerText.setText("Time's up!");
                finishTest();
            }

        }.start();

        //call method onRun
        onRun();
    }

    private void onRun() {
        //find how many questions there are in the question_array
        String[] questionArray = getResources().getStringArray(R.array.question_array);
        numOfQuestions = questionArray.length - 1;

        //call the following methods
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

        //if on last question of the assessment, calls function submitButton
        if (questionNum == numOfQuestions) {
            submitButton();
        }
    }

    private void createRadioButtons() {
        RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

        //create array for answer choices
        String[] answerChoices = {"", "", "", ""};

        //based on what the question number is, will use a different answer_array
        switch (questionNum) {
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

        for (int x = 0; x < childCount; x++) {
            //set text of radiobuttons to text in chosen answer_array
            RadioButton ans = (RadioButton) group_assessment.getChildAt(x);
            ans.setText(arrayText.get(x));
        }

    }

    private void onNextQuestion() {
        Button next_question = findViewById(R.id.next_question);

        //when user clicks next question button
        next_question.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioGroup group_assessment = findViewById(R.id.radiogroup_assessment);

                //retrieve information of what answer the button selected
                int idSelected = group_assessment.getCheckedRadioButtonId();
                RadioButton ans1 = findViewById(idSelected);
                String userChoice = ans1.getText().toString();

                //retrieve items from array
                String[] ans = getResources().getStringArray(R.array.correct_answers);
                ArrayList<String> arrayText = new ArrayList<>();
                Collections.addAll(arrayText, ans);

                //takes correct ans from correct_answers array
                correctAns = arrayText.get(questionNum);

                //checks answer; if correct, updates the score
                if (userChoice.equals(correctAns)) {
                    updateScore();
                }

                //if it is the last question, call method finishTest
                //if it isn't the last question, clear the radio buttons and run again
                if (questionNum == numOfQuestions) {
                    finishTest();
                } else {
                    group_assessment.clearCheck();
                    onRun();
                }
            }
        });

    }

    private void submitButton() {
        Button submit = findViewById(R.id.next_question);
        //change the text of the button to submit
        submit.setText("Submit");

        //if the button is clicked, call method finishTest
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishTest();
            }
        });
    }

    private void finishTest() {
        //put score and question number values into shared preferences
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("score", score);
        editor.putInt("questionNum", numOfQuestions);
        editor.apply();

        //switch activity to assessment_results activity
        Intent intent = new Intent(getApplicationContext(), assessment_results.class);
        startActivity(intent);
    }

    private void updateScore() {
        //adds one to the score
        score=score++;
    }

    private void updateQuestion() {
        //adds one to the question number
        questionNum++;
    }

}


