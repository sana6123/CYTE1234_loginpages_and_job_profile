package com.example.cytelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class employee_login extends AppCompatActivity {
    private DatabaseHelper db;
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Name = (EditText)findViewById(R.id.Loginusername_Cyte);
        Password = (EditText)findViewById(R.id.Loginpassword_Cyte);
        info = (TextView) findViewById(R.id.textView2);
        Login = (Button) findViewById(R.id.Login_Cyte);
        //for checking out the values in the database with the values entered
        db = new DatabaseHelper(this);


        final Button login_button = (Button) findViewById(R.id.Login_Cyte);
        final Button signup_button = (Button) findViewById(R.id.signup_main);

        signup_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                startActivity(new Intent(employee_login.this, employer_snpg.class));
            }});

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get references to text boxes
                EditText username_input = (EditText) findViewById(R.id.Loginusername_Cyte);
                EditText password_input = (EditText) findViewById(R.id.Loginpassword_Cyte);
                // Pull input from text boxes
                String email = username_input.getText().toString();
                String password = password_input.getText().toString();
                // Send username and password to the database and check
                //login_button.setText(username + " " + password); // Get rid of this

                employee_accounts e = db.getEmployeeByEmail(email);
                String ePass = e.getPassword();

                if (password.contentEquals(ePass)) {
                    // Password and Email match. Successful Login
                    // Make your intent and go to employee profile activity.
                    Intent i = new Intent(getApplicationContext(), employer_add_posts.class);
                    startActivity(i);
                    // Remember to put ".class" at the end of the activity name!
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect email or password" + password, Toast.LENGTH_SHORT).show();
                }
                //startActivity(new Intent(employee_login.this, Employee_Profile_Activity.class));
            }
        });
    }
}