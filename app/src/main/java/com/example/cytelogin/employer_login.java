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

        final Button login_button = (Button) findViewById(R.id.login_empr);
        TextView signup = (TextView) findViewById(R.id.signup_main_empr);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Employer_Profile_Activity.class);
                startActivity(intent);
            }});

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get references to text boxes
                EditText username_input = (EditText) findViewById(R.id.username);
                EditText password_input = (EditText) findViewById(R.id.password);
                // Pull input from text boxes
                String email = username_input.getText().toString();
                String password = password_input.getText().toString();
                // Send username and password to the database and check
                //login_button.setText(username + " " + password); // Get rid of this

                employer_accounts e = db.getEmployerByEmail(email);
                String ePass = e.password_empr();



                startActivity(new Intent(employer_login.this, Employee_Profile_Activity.class));

                /*if (password.contentEquals(ePass)) {
                    // Password and Email match. Successful Login
                    // Make your intent and go to employee profile activity.
                    Intent i = new Intent(getApplicationContext(), MainActivity_jobs.class);
                    startActivity(i);
                    // Remember to put ".class" at the end of the activity name!
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect email or password" + password, Toast.LENGTH_SHORT).show();

                }
                //startActivity(new Intent(employee_login.this, Employee_Profile_Activity.class));
*/
            }
        });
    }
}