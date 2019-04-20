package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity_e_c extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button button2 = findViewById(R.id.employer_startupbuttton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(MainActivity_e_c.this, employer_login.class));

                // your handler code here
                //Intent intent = new Intent(getApplicationContext(), employer_login.class);
                //intent.putExtra("switch", 1);
                //0 is employee and 1 is employer
                //startActivity(intent);

            }
        });


        //myDb = new DatabaseHelper(getApplicationContext());


    }
}
