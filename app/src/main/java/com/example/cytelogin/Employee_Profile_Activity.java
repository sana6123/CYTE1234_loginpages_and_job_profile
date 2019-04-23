package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Employee_Profile_Activity extends AppCompatActivity {
    //this is from the video
    DatabaseHelper empeedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_signup);

        //this is from the video, calling out the database whenever this constructor is called
        ////
        empeedb = new DatabaseHelper(getApplicationContext());


       // startActivity(new Intent(Employee_Profile_Activity.this, MainActivity_jobs.class));
        final Button button = (Button) findViewById(R.id.candidate_signupdn);
       // final Button employee_button1 = (Button) findViewById(R.id.employee_button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText firstnm_input = (EditText) findViewById(R.id.candidate_company_name);
                EditText employee_phone = (EditText) findViewById(R.id.candidate_phone_cyte);
                EditText employee_email = (EditText) findViewById(R.id.candidate_emailcyte);
                EditText employee_password = (EditText) findViewById(R.id.candidate_pass_cyte);
                EditText employee_location = (EditText) findViewById(R.id.candidate_location_cyte);

                // Pull input from text boxes
                String employee_name1 = firstnm_input.getText().toString();
                String employee_phone1 = employee_phone.getText().toString();
                String employee_email1 = employee_email.getText().toString();
                String employee_password1 = employee_password.getText().toString();
                String employee_location1 = employee_location.getText().toString();

                empeedb.addEmployee(employee_name1,employee_phone1,employee_email1,employee_password1, employee_location1);

// Send username and password to the database and check
                Intent intent = new Intent(getApplicationContext(),MainActivity_jobs.class);
                startActivity(intent);

                //login_button.setText(username + " " + password); // Get rid of this
                Toast.makeText(getApplicationContext(), "Your data is stored", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

