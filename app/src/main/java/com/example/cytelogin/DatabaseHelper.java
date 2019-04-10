package com.example.cytelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


//in the constructor we create a database
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "jobs.db"; //name of the db
    public static final String TABLE_NAME = "jobs.table"; //table name
    public static final String ID_1 = "ID"; //column 1 name
    public static final String TITLE_2 = "TITLE"; //column 2 name
    public static final String INDUSTRY_3 = "INDUSTRY"; //column 3 name
    public static final String CITY_4 = "CITY"; //column 4 name

//constructor //whenever it is called, the database will be created
    //whatever is included in this section is created when db is called
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //creates database and table
        SQLiteDatabase db = this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //where you create a table? metjod that executes when database is called
        db.execSQL(String.format("create table" + TABLE_NAME +"  (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, INDUSTRY TEXT, CITY TEXT)", TABLE_NAME));
        //"CREATE TABLE " + TABLE_NAME + "(" + ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITLE_2 + " TEXT," + INDUSTRY_3 + " TEXT," + CITY_4 + " TEXT"+ ")"
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    onCreate(db);
    }


    ArrayList<Jobposts> getAllApplications(String title, String industry,String city) {
        ArrayList<Jobposts> jobsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_1,
                        TITLE_2, INDUSTRY_3, CITY_4}, ID_1 + "=?"+ TITLE_2 + "=?" + " AND " + INDUSTRY_3 + "=?" + " AND " + CITY_4 + "=?",
                new String[]{ String.valueOf(title), String.valueOf(industry), String.valueOf(city) }, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Jobposts sa = new Jobposts(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                jobsList.add(sa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jobsList;
    }





    Jobposts getApplication(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_1,
                        TITLE_2, INDUSTRY_3, CITY_4}, TITLE_2 + "=?",
                new String[]{ String.valueOf(id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        cursor.close();
        return new Jobposts (Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
    }







    public boolean insertData (int id, String title, String industry, String city) {
///insert values
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_1, id);
        contentValues.put(TITLE_2, title);
        contentValues.put(INDUSTRY_3, industry);
        contentValues.put(CITY_4, city);
    long result = db.insert(TABLE_NAME, null, contentValues);
    //gives -1 result if there is an error
if(result == -1)
    return false;
else
    return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
