package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class employer_startuppage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_startuppage);


//to go to job posts page
        final Button login_empr = findViewById(R.id.login_empr);
        login_empr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), employer_login.class);
                startActivity(intent);
            }
        });
//
        final TextView signup_empr =findViewById(R.id.signup_main_empr);
        signup_empr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), employer_snpg.class);
                startActivity(intent);

            }
        });
    }

}