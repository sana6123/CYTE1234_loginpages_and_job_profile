package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Employer_Profile_Activity {
    DatabaseHelper emperdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_signuppg);

        //this is from the video, calling out the database whenever this constructor is called
        emperdb = new DatabaseHelper(this);


        startActivity(new Intent(Employer_Profile_Activity.this, job_profile.class));
        final Button button = (Button) findViewById(R.id.employer_signupbn);

        employer_signupbn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // your handler code here
            EditText employer_companyname = (EditText) findViewById(R.id.employer_fname_cyte);
            EditText employer_phone = (EditText) findViewById(R.id.employer_emailcyte);
            EditText employer_email = (EditText) findViewById(R.id.employer_phone_cyte);
            EditText employer_password = (EditText) findViewById(R.id.employer_pass_cyte);
            EditText employer_location = (EditText) findViewById(R.id.employer_location_cyte);

            // Pull input from text boxes
            String employee_name1 = employer_companyname.getText().toString();
            String employee_phone1 = employer_phone.getText().toString();
            String employee_email1 = employer_email.getText().toString();
            String employee_password1 = employer_password.getText().toString();
            String employee_location1 = employer_location.getText().toString();

            emperdb.addEmployer(employer_companyname,employer_phone,employer_email,employer_password, employer_location);

// Send username and password to the database and check

            //login_button.setText(username + " " + password); // Get rid of this
            Toast.makeText(getApplicationContext(), "Your data is stored", Toast.LENGTH_SHORT).show();

            //startActivity(new Intent(employee_login.this, Employee_Profile_Activity.class));
        }
    });
}
}

        }
