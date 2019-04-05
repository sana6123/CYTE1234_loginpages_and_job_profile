package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity_e_c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Temp code that shows employee form
        Intent intent = new Intent(getApplicationContext(), Employee_Profile_Activity.class);
        startActivity(intent);

    }
}
