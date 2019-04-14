package com.example.cytelogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database_profile_employee extends SQLiteOpenHelper {

    //declaring our database name
    public static final String DATABASE_name="Employee_info_storage";
    public static final String TABLE_NAME="employee_profile";
    //declaring our table names that would be included in this database
    public static final String COL_1="Name";
    public static final String COL_2="Phone";
    public static final String COL_3="Email";
    public static final String COL_4="Password";
    public static final String COL_5="Confirm_Password";
    public static final String COL_6="Postal_code";


//whenever this constructor would be called database would be created
    public database_profile_employee(Context context) {
        super(context, DATABASE_name, null, 1);
        database_profile_employee db= this.getWritableDatabase()
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //for creating tables inside our database
        db.execSQL("create table" +TABLE_NAME+" (Name TEXT PRIMARY KEY AUTOINCREMENT, Phone INTEGER,Email TEXT,Password INTEGER,Confirm_Password INTEGER,Postal_code INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
    }
}
