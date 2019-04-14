package com.example.cytelogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


    public class database_profile_employer extends SQLiteOpenHelper {

        //declaring our database name
        public static final String DATABASE_name="Employer_info_storage";
        public static final String TABLE_NAME="employer_profile";
        //declaring our table names that would be included in this database
        public static final String COL_1="Company Name";
        public static final String COL_2="Email";
        public static final String COL_3="Phone Number";
        public static final String COL_4="Password";
        public static final String COL_5="Postal_code";


        //whenever this constructor would be called database would be created
        public database_profile_employer(Context context) {
            super(context, DATABASE_name, null, 1);
            SQLiteDatabase db= this.getWritableDatabase();
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            //for creating tables inside our database
            db.execSQL(String.format("create table if not exists" +TABLE_NAME+" (Name TEXT PRIMARY KEY AUTOINCREMENT, Phone INTEGER,Email TEXT,Password INTEGER,Confirm_Password INTEGER,Postal_code INTEGER)"));

            String query = "CREATE TABLE IF NOT EXISTS" +TABLE_NAME+"("+COL_1+"TEXT PRIMARY KEY AUTOINCREMENT," + COL_2 + "INTEGER"+ COL_3 + "TEXT" +  COL_4 + "INTEGER" + COL_5 +"TEXT)";

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        }
    }

}
