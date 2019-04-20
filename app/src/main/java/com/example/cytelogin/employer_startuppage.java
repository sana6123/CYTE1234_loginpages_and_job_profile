package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class employer_startuppage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_startuppage);

        final Button button2 = findViewById(R.id.);
        final
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), employer_snpg.class);
                startActivity(intent);

            }
        });
    }

}