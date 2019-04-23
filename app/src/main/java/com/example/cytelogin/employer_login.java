package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class employer_login extends AppCompatActivity {
    //initializes variables
    private DatabaseHelper db;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //it would go to this activity
        setContentView(R.layout.activity_employer_startuppage);

      /*  Name = (EditText)findViewById(R.id.employer_company_name);
        Password = (EditText)findViewById(R.id.employer_email);
        info = (TextView) findViewById(R.id.employer_phone_cyte);
        Login = (Button) findViewById(R.id.login_empr);
        //for checking out the values in the database with the values entered
        db = new DatabaseHelper(getApplicationContext());
      */
        db = new DatabaseHelper(getApplicationContext());
        final Button login_button = findViewById(R.id.login_empr);
        TextView signup = findViewById(R.id.signup_main_empr);

        //if signup button clicked
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates new intent, switches activity to Employer_Profile_Activity
                Intent intent = new Intent(getApplicationContext(), Employer_Profile_Activity.class);
                startActivity(intent);
            }});

        //if login_button clicked
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: IF ABLE TO MAKE THE PASSWORD WORK, TAKE THIS OUT
                //creates new intent, switches activity to MainActivity_jobs (job listings screen)
               // Intent i = new Intent(getApplicationContext(), MainActivity_jobs.class);
                //startActivity(i);

                // Get references to text boxes
                EditText username_input = findViewById(R.id.username);
                EditText password_input = findViewById(R.id.password);



                // Send username and password to the database and check
                //login_button.setText(username + " " + password); // Get rid of this

                if (db.checkEr(username_input.getText().toString(), password_input.getText().toString())) {
                    // Password and Email match. Successful Login
                    // Make your intent and go to employee profile activity.
                    Intent intent = new Intent(getApplicationContext(), MainActivity_jobs.class);
                    startActivity(intent);
                    // Remember to put ".class" at the end of the activity name!
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}