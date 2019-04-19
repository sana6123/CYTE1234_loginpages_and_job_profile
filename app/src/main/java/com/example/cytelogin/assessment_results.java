package com.example.cytelogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class assessment_results extends AppCompatActivity {

    int score;
    int questionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assessment_results);

        String MyPrefs = "myprefs";
        SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences(MyPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();


        score = sharedpreferences.getInt("score",0);
        questionNum = sharedpreferences.getInt("questionNum",1);

        onRun();

    }

    public void onRun(){
        TextView result = findViewById(R.id.result);

        float temp = (float)score/(float)questionNum;
        int finalScore = (int)(temp*(float)100);

        result.setText(String.format(Locale.CANADA, "Score: %d%%", finalScore));

        if (finalScore<75){
            
        }


        //If score is lower than 70%, refer to educational websites
        // a choice to go back to browsing page

    }


}
