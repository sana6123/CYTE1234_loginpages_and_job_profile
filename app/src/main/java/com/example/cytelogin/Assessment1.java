package com.example.cytelogin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Assessment1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment1);

        Bundle args = new Bundle();
        args.putString("Question","How old are you?");

        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragMan.beginTransaction();

        Fragment myFrag = new BlankFragment();
        myFrag.setArguments(args);

        LinearLayout layout = findViewById(R.id.assess_layout);
        //layout.setId(2);

        int fragCount=1;
        fragTransaction.add(myFrag, "fragment" +fragCount);
        fragTransaction.commit();



    }
}
