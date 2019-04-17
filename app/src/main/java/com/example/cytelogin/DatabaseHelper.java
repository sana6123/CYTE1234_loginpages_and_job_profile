package com.example.cytelogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.widget.Space;

import java.util.List;


//in the constructor we create a database
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "jobs"; //name of the db
    public static final String TABLE_NAME = "jobsTable"; //table name
    public static final String ID_1 = "ID"; //column 1 name
    public static final String TITLE_2 = "TITLE"; //column 2 name
    public static final String INDUSTRY_3 = "INDUSTRY"; //column 3 name
    public static final String CITY_4 = "CITY"; //column 4 name

    public static final String EMPLOYEE_NAME="employee_profile";
    //declaring our table names that would be included in this database
    private static final String KEY_ID = "idd";
    public static final String COL_1="Name";
    public static final String COL_2="Phone";
    public static final String COL_3="Email";
    public static final String COL_4="Password";
    public static final String COL_5="Postal_code";

    private static final String COMPLETED_ASSESSMENTS="completed_assessments";
    public static final String CA_EMP_ID="Employee ID";
    public static final String CA_JP_ID="Job Post ID";



    //constructor //whenever it is called, the database will be created
    //whatever is included in this section is created when db is called
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //creates database and table
        //SQLiteDatabase db = this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //where you create a table? metjod that executes when database is called
        db.execSQL(String.format("create table if not exists " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, INDUSTRY TEXT, CITY TEXT)"));

        String createJobPostsTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITLE_2 + " TEXT," + INDUSTRY_3 + " TEXT," + CITY_4 + " TEXT)";
        db.execSQL(createJobPostsTable);

        String createEmployeeTable = "CREATE TABLE IF NOT EXISTS " +EMPLOYEE_NAME+"("+"KEY_ID PRIMARY KEY AUTOINCREMENT,"+COL_1+"STRING" + COL_2 + "INTEGER"+ COL_3 + "STRING" +  COL_4 + "INTEGER" + COL_5 +"STRING)";
        db.execSQL(createEmployeeTable);

        //String createEmployerTable =
        //db.execSQL(query1);
        String createCompletedAssessmentsTable = "CREATE TABLE IF NOT EXISTS " +EMPLOYEE_NAME+"("+"KEY_ID PRIMARY KEY AUTOINCREMENT,"+COL_1+"STRING" + COL_2 + "INTEGER"+ COL_3 + "STRING" +  COL_4 + "INTEGER" + COL_5 +"STRING)";
        db.execSQL(createCompletedAssessmentsTable);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    //onCreate(db);
    }

    Jobposts getApplication ( int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_1,
                        TITLE_2, INDUSTRY_3, CITY_4}, TITLE_2 + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        cursor.close();
        return new Jobposts(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
    }

    ArrayList<Jobposts> getAllApplications(String title, String industry,String city) {
        ArrayList<Jobposts> jobsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_1,
                        TITLE_2, INDUSTRY_3, CITY_4}, ID_1 + "=? AND "+ TITLE_2 + "=?" + " AND " + INDUSTRY_3 + "=?" + " AND " + CITY_4 + "=?",
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
    //EMPLOYEE
    ArrayList<employee_accounts> getallemployee() {
        ArrayList<employee_accounts> appsList = new ArrayList<>();
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
                employee_accounts spaceshipApplication = new employee_accounts (
                        cursor.getString(1), // name
                        cursor.getString(2), // phonenumber
                        cursor.getString(3), // email
                        cursor.getString(4),// password
                        cursor.getString(5) // postalcode
                );

                appsList.add(spaceshipApplication); // then add it to our list
            } while (cursor.moveToNext()); // Is there another row after this one? If not, we're done.
        }
        cursor.close();
        db.close();
        return appsList;
    }
    //EMPLOYEE
    employee_accounts getemployee(int id) {
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
        Cursor cursor = db.query(EMPLOYEE_NAME, new String[]{KEY_ID,
                        COL_1, COL_2, COL_3, COL_4,COL_5}, KEY_ID + "=?",
                new String[]{ String.valueOf(id) }, null, null, null, null);
        if (cursor != null) { // If there are non-zero rows returned
            cursor.moveToFirst(); // go to the first one
        }
        cursor.close();
        return new employee_accounts(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5));
    }

    employee_accounts getEmployeeByEmail(String email) {
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
        Cursor cursor = db.query(EMPLOYEE_NAME, new String[]{KEY_ID,
                        COL_1, COL_2, COL_3, COL_4,COL_5}, COL_3 + "=?",
                new String[]{ email }, null, null, null, null);
        if (cursor != null) { // If there are non-zero rows returned
            cursor.moveToFirst(); // go to the first one
        }
        cursor.close();
        return new employee_accounts(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5));
    }

    public boolean addEmployee(String name, String phone, String email, String password, String postalCode) {
///insert values
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, phone);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, password);
        contentValues.put(COL_5, postalCode);
        long result = db.insert(EMPLOYEE_NAME, null, contentValues);
        //gives -1 result if there is an error
        if(result == -1) {


            db.close();
            return false;
        } else {
            db.close();

            return true;
        }
    }

    public boolean addJobPost(int id, String title, String industry, String city) {
///insert values
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_1, id);
        contentValues.put(TITLE_2, title);
        contentValues.put(INDUSTRY_3, industry);
        contentValues.put(CITY_4, city);
    long result = db.insert(TABLE_NAME, null, contentValues);
    //gives -1 result if there is an error
if(result == -1) {


    db.close();
    return false;
} else {
    db.close();

    return true;
}
    }
//when the employee finishes their assessment the addCompletedAssessnt
    public boolean addCompletedAssessment(int jobPostID, int employeeID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CA_EMP_ID, employeeID);
        contentValues.put(CA_JP_ID, jobPostID);
        long result = db.insert(COMPLETED_ASSESSMENTS, null, contentValues);
        //gives -1 result if there is an error
        if(result == -1) {
            db.close();
            return false;
        } else {
            db.close();

            return true;
        }
    }

   //this will get us all the completed assessment = id jobposts+id for employee
    //and the employer would be given the employee id

    ArrayList<Integer> getAllCompletedAssessments(int jobPostID) {
        ArrayList<Integer> employeeList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(COMPLETED_ASSESSMENTS, new String[]{CA_EMP_ID, CA_JP_ID}, CA_JP_ID + "=?",
                new String[]{ Integer.toString(jobPostID) }, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Integer i = new Integer(
                        Integer.parseInt(cursor.getString(0))
                );
                employeeList.add(i);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return employeeList;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    //EMPLOYEE
    int update_employee(employee_accounts sa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_1, sa.getIdd());//name
        values.put(COL_2, sa.getPhone());//phone
        values.put(COL_3, sa.getEmail());//email
        values.put(COL_4, sa.getPassword());//password
        values.put(COL_5, sa.getPostal_code());//postalcode

        return db.update(EMPLOYEE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(sa.getIdd())});
    }
    //EMPLOYEE
    public void delete_employee(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EMPLOYEE_NAME, KEY_ID + "=?", new String[] {String.valueOf(id)});
        db.close();
    }
}

