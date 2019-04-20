package com.example.cytelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class employer_snpg extends AppCompatActivity {

    employer_accounts emperdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_signuppg);



//for declaring the buttons and telling the buttons where to link the next screen if the user clickson this screen
        final Button employer_profile = (Button) findViewById(R.id.employer_signupbn);



//for connecting the screens using buttons
//signup_button.setOnClickListener(new View.OnClickListener() {
//public void onClick(View v) {
 // your handler code here
 //startActivity(new Intent(employee_login.this, employer_snpg.class));
 // }});

        employer_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), makeAssessment_employer.class);
                startActivity(intent);

                // Get references to text boxes
                EditText companynm_input = (EditText) findViewById(R.id.employer_company_name);
                EditText email_input = (EditText) findViewById(R.id.employer_email);
                EditText employer_phone = (EditText) findViewById(R.id.employer_phone_cyte);
                EditText employer_password = (EditText) findViewById(R.id.employer_pass_cyte);
                EditText employer_location = (EditText) findViewById(R.id.employer_location_cyte);


                // Pull input from text boxes
                String employer_companyname = companynm_input.getText().toString();
                String employer_email = email_input.getText().toString();
                String employer_phonenumber = employer_phone.getText().toString();
                String employer_password1 = employer_password.getText().toString();
                String employer_location1 = employer_location.getText().toString();

                emperdb = new employer_accounts(employer_companyname,employer_email,employer_phonenumber,employer_password1, employer_location1);

                // Send username and password to the database and check
                //login_button.setText(username + " " + password); // Get rid of this
                Toast.makeText(getApplicationContext(), "Data is stored", Toast.LENGTH_SHORT).show();


                startActivity(new Intent(getApplicationContext(), makeAssessment_employer.class));

            }
        });
    }
}

