package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Employer_Profile_Activity extends AppCompatActivity {
    private DatabaseHelper emperdb;

   // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_signuppg);

        //this is from the video, calling out the database whenever this constructor is called
        emperdb = new DatabaseHelper(getApplicationContext());


        //startActivity(new Intent(Employer_Profile_Activity.this, job_profile.class));
        final Button employer_signup = (Button) findViewById(R.id.employer_signupbn);

        //if employer_signup button clicked
        employer_signup.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {


            // your handler code here
            EditText employer_companyname = findViewById(R.id.employer_company_name);
            EditText employer_phone = findViewById(R.id.employer_email);
            EditText employer_email = findViewById(R.id.employer_phone_cyte);
            EditText employer_password = findViewById(R.id.employer_pass_cyte);
            EditText employer_location = findViewById(R.id.employer_location_cyte);

            // Pull input from text boxes
            String employer_name1 = employer_companyname.getText().toString();
            String employer_phone1 = employer_phone.getText().toString();
            String employer_email1 = employer_email.getText().toString();
            String employer_password1 = employer_password.getText().toString();
            String employer_location1 = employer_location.getText().toString();

            if (emperdb.addEmployer(employer_name1, employer_phone1, employer_email1, employer_password1, employer_location1)) {


                // Send username and password to the database and check
                //creates new intent, switches activity to employer_add_posts
                Intent intent = new Intent(getApplicationContext(), employer_login.class);
                startActivity(intent);
                //login_button.setText(username + " " + password); // Get rid of this
                Toast.makeText(getApplicationContext(), "Your data is stored", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    });
}
}


