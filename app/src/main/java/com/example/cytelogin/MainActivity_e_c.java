package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity_e_c extends AppCompatActivity {


    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(getApplicationContext());

        //Temp code that shows employee form
        Intent intent = new Intent(getApplicationContext(), employee_login.class);
        startActivity(intent);

    }
}
