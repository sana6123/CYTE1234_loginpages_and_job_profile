package com.example.cytelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class database_profile_employer extends SQLiteOpenHelper {

        //declaring our database name
        public static final String DATABASE_name="Employer_info_storage";
        public static final String TABLE_NAME="employer_profile";
        //declaring our table names that would be included in this database
        private static final String KEY_IDD = "id";
        public static final String COL_1="Company_Name";
        public static final String COL_2="Email_employer";
        public static final String COL_3="Phone_employer";
        public static final String COL_4="Password_employer";
        public static final String COL_5="Postal_code_employer";


        //whenever this constructor would be called database would be created
        public database_profile_employer(Context context) {
            super(context, DATABASE_name, null, 1);
            SQLiteDatabase db= this.getWritableDatabase();
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            //for creating tables inside our database
            db.execSQL(String.format("create table if not exists" +TABLE_NAME+" (COMPANY_NAME TEXT PRIMARY KEY AUTOINCREMENT, Email_EMPLOYER TEXT ,PHONE_EMPLOYER INTEGER,Password INTEGER,Postal_code STRING)"));

            String query = "CREATE TABLE IF NOT EXISTS" +TABLE_NAME+"("+COL_1+"TEXT PRIMARY KEY AUTOINCREMENT," + COL_2 + "STRING"+ COL_3 + "INTEGER" +  COL_4 + "INTEGER" + COL_5 +"STRING)";

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        }
    // Add an entry into the table. In this case, we're adding SpaceshipApplication objects.
    // Takes one argument, the SpaceshipApplication to add to the table.
    void addApplication(database_profile_employee Employee_signup) {
        // Open a writable instance of the database so we can make changes to it.
        SQLiteDatabase db = this.getWritableDatabase();

        // To insert a value into the database, we'll use a ContentValues object, which you can think of as a new blank row.
        ContentValues values = new ContentValues();
        // Filling in the details of this row
        values.put(COL_1,Employee_signup.getName());
        values.put(COL_2, Employee_signup.getPhone());
        values.put(COL_3,Employee_signup .getEmail());
        values.put(COL_4,Employee_signup .getPassword());
        values.put(COL_5,Employee_signup .getPostalcode());


        // inserting the row which is filled in with the details from the SpaceshipApplication into the table.
        db.insert(TABLE_NAME, null, values);
        // Close the database that we opened so we don't run into weird memory problems.
        db.close();
    }

    // Return a list of all the rows in the database as SpaceshipApplication objects.
    ArrayList<database_profile_employee> getAllApplications() {
        ArrayList<database_profile_employee> appsList = new ArrayList<>();
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // A Cursor is used as a way to navigate a set of rows returned by a query to a database.
        // Query: SELECT * FROM TABLE_NAME
        // * is a shorthand for "everything".
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // If the query returns a non-zero amount of rows, the if block will execute. If nothing was returned,
        // i.e. the query resulted in 0 matching results, then cursor.moveToFirst() fails and returns false, skipping the if block.
        if (cursor.moveToFirst()) {
            // A do-while loop will always execute at least once, whereas a regular while loop checks the condition at the beginning and
            // can potentially never execute code inside itself.
            do {
                // From the row that the Cursor is currently looking at, make a new SpaceshipApplication object and fill in the details using info from the retrieved row
                database_profile_employee spaceshipApplication = new database_profile_employee(
                        Integer.parseInt(cursor.getString(0)), // id
                        cursor.getString(1), // name
                        cursor.getInt(2), // phonenumber
                        cursor.getString(3), // email
                        cursor.getString(4), // password
                        cursor.getString(5) // postalcode

                );
                appsList.add(spaceshipApplication); // then add it to our list
            } while (cursor.moveToNext()); // Is there another row after this one? If not, we're done.
        }
        cursor.close();
        db.close();
        return appsList;
    }

    // Returns a SpaceshipApplication based on the unique ID.
    database_profile_employee getApplication(int id) {
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_IDD,
                        COL_1, COL_2, COL_3, COL_4,COL_5}, KEY_IDD + "=?",
                new String[]{ String.valueOf(id) }, null, null, null, null);
        if (cursor != null) { // If there are non-zero rows returned
            cursor.moveToFirst(); // go to the first one
        }
        cursor.close();
        return new database_profile_employee(Integer.parseInt(cursor.getInt(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5));
    }
    // Given some spaceshipApplication, update the corresponding database entry with the same ID using the new values
    int updateApplication(database_profile_employee sa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_1, sa.getName());//name
        values.put(COL_2, sa.getPhoneNumber());//phone
        values.put(COL_3, sa.getEmail());//email
        values.put(COL_4, sa.getPassword());//password
        values.put(COL_5, sa.getPostalCode());//postalcode

        return db.update(TABLE_NAME, values, KEY_IDD + "=?", new String[]{String.valueOf(sa.getId())});
    }
    // Find the entry by ID and delete it.
    public void deleteApplication(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_IDD + "=?", new String[] {String.valueOf(id)});
        db.close();
    }
}






///figure out a way of connecting the users input and link it with the database
//figure out a way for putting an anonomys identity
