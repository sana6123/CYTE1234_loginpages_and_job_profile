package com.example.cytelogin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class skill_Test extends AppCompatActivity {

    private CheckBox  mcheckcalculation, mcheckpublic, mcheckproblem, mcheckassessing, mcheckclassifiying,
                 mchecktechnological,mcheckquality, mcheckdisplaying, mcheckelaboration, mcheckanalytical;

    private Button mselectedskillbutton;
    private TextView mresulttextview;
    private ArrayList<String> mresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_skill_test);

        mcheckcalculation = findViewById(R.id.check_Calculation);
        mcheckpublic = findViewById(R.id.check_Public);
        mcheckproblem = findViewById(R.id.check_Problem);
        mcheckassessing = findViewById(R.id.check_Assessing);
        mcheckclassifiying = findViewById(R.id.check_Classifying);
        mchecktechnological = findViewById(R.id.check_Technological);
        mcheckquality = findViewById(R.id.check_Quality);
        mcheckdisplaying = findViewById(R.id.check_Displaying);
        mcheckelaboration = findViewById(R.id.check_Elaboration);
        mcheckanalytical = findViewById(R.id.check_Analytical);

        mselectedskillbutton = findViewById(R.id.button_Select);
        mresulttextview = findViewById(R.id.results);
        mresult = new ArrayList<>();
        mresulttextview.setEnabled(false);


        mcheckcalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckcalculation.isChecked())
                    mresult.add("Calculation -Using basic arithmetic skills including adding, subtracting, multiplication and division");
                else
                    mresult.remove("Calculation -Using basic arithmetic skills including adding, subtracting, multiplication and division");

            }
        });


        mcheckpublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckpublic.isChecked())
                    mresult.add("Public Speaking- addressing or delivering a speech to a group or audience.");
                else
                    mresult.remove("Public Speaking- addressing or delivering a speech to a group or audience.");

            }
        });

        mcheckproblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckproblem.isChecked())
                    mresult.add("Problem solving - defining a problem, seeking alternatives, selecting a solution");
                else
                    mresult.remove("Problem solving - defining a problem, seeking alternatives, selecting a solution");


            }
        });

        mcheckassessing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckassessing.isChecked())
                    mresult.add("Assessing - correctly determining the nature of a situation or issue.");
                else
                    mresult.remove("Assessing - correctly determining the nature of a situation or issue.");

            }
        });


        mcheckclassifiying.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
               if (mcheckclassifiying.isChecked())
                   mresult.add("Classifying - using and adapting a complex organization system for the storage and efficient retrieval of information.");
               else
                  mresult.remove("Classifying - using and adapting a complex organization system for the storage and efficient retrieval of information.");

     }

  });

        mchecktechnological.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mchecktechnological.isChecked())
                    mresult.add("Technological - understanding and performing basic computer tasks and  logical technology skills.");
                else
                    mresult.remove("Technological - understanding and performing basic computer tasks and  logical technology skills.");


            }
        });

        mcheckquality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckquality.isChecked())
                    mresult.add("Assessing quality - correctly determining the worth of the work you are performing.");
                else
                    mresult.remove("Assessing quality - correctly determining the worth of the work you are performing.");

            }
        });

        mcheckdisplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckdisplaying.isChecked())
                    mresult.add("Designing/displaying - organizing spaces, products, objects, colours or images creatively.");
                else
                    mresult.remove("Designing/displaying - organizing spaces, products, objects, colours or images creatively.");

            }
        });


        mcheckelaboration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckelaboration.isChecked())
                    mresult.add("Elaboration: Connecting new ideas to what you already know.");
                else
                    mresult.remove("Elaboration: Connecting new ideas to what you already know.");

            }
        });

        mcheckanalytical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckanalytical.isChecked())
                    mresult.add("Analytical skills. Identifying a problem and coming up with a technological solution to address it.");
                else
                    mresult.remove("Analytical skills. Identifying a problem and coming up with a technological solution to address it.");

            }
        });


        mselectedskillbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mresult)
                    stringBuilder.append(s).append("\n");

                mresulttextview.setText(stringBuilder.toString());
                mresulttextview.setEnabled(false);
            }
        });

        final Button select = findViewById(R.id.button_Select);

        //when user finishes checking off skills, clicks button select
        select.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //creates new intent, switches activity to Assessment1
                Intent intent = new Intent(getApplicationContext(), Assessment1.class);
                startActivity(intent);
            }
        });




            }}

