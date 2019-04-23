package com.example.cytelogin;
//import com.cytelogin.loginregister.model.employee_accounts;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.HashMap;


//in the constructor we create a database for jobposts
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "jobs"; //name of the db
    public static final String TABLE_NAME = "jobsTable"; //table name
    public static final String ID_1 = "id"; //column 1 name
    public static final String TITLE_2 = "TITLE"; //column 2 name
    public static final String INDUSTRY_3 = "INDUSTRY"; //column 3 name
    public static final String CITY_4 = "CITY"; //column 4 name

    //A new table for saving the information for employee
    public static final String EMPLOYEE_NAME="employee_profile";
    private static final String KEY_ID = "id";
    public static final String COL_1="Name";
    public static final String COL_2="Phone";
    public static final String COL_3="Email";
    public static final String COL_4="Password";
    public static final String COL_5="Postal_code";

    //a database for saving the information for employer
    public static final String EMPLOYER_NAME = "employer_profile";
    private static final String KEY_IDD = "id";
    public static final String EMPR_1="Company_Name";
    public static final String EMPR_2="Email_employer";
    public static final String EMPR_3="Phone_employer";
    public static final String EMPR_4="Password_employer";
    public static final String EMPR_5="Postal_code_employer";



    //a database for anonymous identity
    private static final String COMPLETED_ASSESSMENTS="completed_assessments";
    public static final String CA_EMP_ID="Employee ID";
    public static final String CA_JP_ID="Job Post ID";
    private static final int DATABASE_VERSION = 1;


    //constructor //whenever it is called, the database will be created
    //whatever is included in this section is created when db is called
  
        //creates database and table
        //SQLiteDatabase db = this.getWritableDatabase();

    public  DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //where you create a table? method that executes when database is called
      // db.execSQL(String.format("create table if not exists " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, INDUSTRY TEXT, CITY TEXT)"));

        String createJobPostsTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + TITLE_2 + " TEXT," + INDUSTRY_3 + " TEXT," + CITY_4 + " TEXT)";
        db.execSQL(createJobPostsTable);

        String createEmployeeTable = "CREATE TABLE IF NOT EXISTS " +EMPLOYEE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_1+"TEXT" + COL_2 + "TEXT"+ COL_3 + "TEXT" +  COL_4 + "TEXT" + COL_5 +"TEXT)";
        db.execSQL(createEmployeeTable);

        String createEmployerTable = "CREATE TABLE IF NOT EXISTS " + EMPLOYER_NAME +"("+ KEY_IDD+" INTEGER PRIMARY KEY AUTOINCREMENT,"+EMPR_1+ "TEXT" + EMPR_2+ "TEXT" + EMPR_3 +"TEXT"+ EMPR_4+ "TEXT" + EMPR_5 +"TEXT)";
        db.execSQL(createEmployerTable);



        //String createEmployerTable =
        //db.execSQL(query1);
        String createCompletedAssessmentsTable =  "CREATE TABLE IF NOT EXISTS " + COMPLETED_ASSESSMENTS +"("+ KEY_IDD+" INTEGER PRIMARY KEY AUTOINCREMENT,"+EMPR_1+ "TEXT" + EMPR_2+ "TEXT" + EMPR_3 +"TEXT"+ EMPR_4+ "TEXT" + EMPR_5 +"TEXT)";

        db.execSQL(createCompletedAssessmentsTable);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    onCreate(db);
    }



    /*Jobposts getApplication ( int id){
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

    Cursor getAllApplications(String title, String industry,String city) {
        ArrayList<Jobposts> jobsList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID_1,
                        TITLE_2, INDUSTRY_3, CITY_4},  TITLE_2 + "=?" + " OR " + INDUSTRY_3 + "=?" + " AND " + CITY_4 + "=?",
                new String[]{ String.valueOf(title), String.valueOf(industry), String.valueOf(city) }, null, null, null, null);

            return cursor;
    }*/
    //EMPLOYER
    ArrayList<employer_accounts> getAllEmployer() {
        ArrayList<employer_accounts> appsList = new ArrayList<>();
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // A Cursor is used as a way to navigate a set of rows returned by a query to a database.
        // Query: SELECT * FROM TABLE_NAME
        // * is a shorthand for "everything".
        Cursor cursor = db.rawQuery("SELECT * FROM " + EMPLOYER_NAME, null);

        // If the query returns a non-zero amount of rows, the if block will execute. If nothing was returned,
        // i.e. the query resulted in 0 matching results, then cursor.moveToFirst() fails and returns false, skipping the if block.
        if (cursor.moveToFirst()) {
            // A do-while loop will always execute at least once, whereas a regular while loop checks the condition at the beginning and
            // can potentially never execute code inside itself.
            do {
                // From the row that the Cursor is currently looking at, make a new SpaceshipApplication object and fill in the details using info from the retrieved row
                employer_accounts spaceshipApplication = new employer_accounts(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                );

                appsList.add(spaceshipApplication); // then add it to our list
            } while (cursor.moveToNext()); // Is there another row after this one? If not, we're done.
        }
        cursor.close();
        db.close();
        return appsList;



    //EMPLOYEE

    } ArrayList<employee_accounts> getAllEmployee() {
        ArrayList<employee_accounts> appsList = new ArrayList<>();
        // we aren't making any changes so use a readable database, not a writable one.
        SQLiteDatabase db = this.getReadableDatabase();

        // A Cursor is used as a way to navigate a set of rows returned by a query to a database.
        // Query: SELECT * FROM TABLE_NAME
        // * is a shorthand for "everything".
        Cursor cursor = db.rawQuery("SELECT * FROM " + EMPLOYEE_NAME, null);

        // If the query returns a non-zero amount of rows, the if block will execute. If nothing was returned,
        // i.e. the query resulted in 0 matching results, then cursor.moveToFirst() fails and returns false, skipping the if block.
        if (cursor.moveToFirst()) {
            // A do-while loop will always execute at least once, whereas a regular while loop checks the condition at the beginning and
            // can potentially never execute code inside itself.
            do {
                // From the row that the Cursor is currently looking at, make a new SpaceshipApplication object and fill in the details using info from the retrieved row
                employee_accounts spaceshipApplication = new employee_accounts(
                        cursor.getString(1), // name
                        cursor.getString(2), // phonenumber
                        cursor.getString(3), // email
                        cursor.getString(4),// password
                        cursor.getString(5) // postalcode
                );

                appsList.add(spaceshipApplication); // then add it to our list
            }
            while (cursor.moveToNext()); // Is there another row after this one? If not, we're done.
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

            Cursor cursor2 = db.query(EMPLOYEE_NAME, new String[]{KEY_IDD,
                            COL_1, COL_2, COL_3, COL_4, COL_5}, KEY_IDD + "=?",
                    new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor2 != null) { // If there are non-zero rows returned
                cursor2.moveToFirst(); // go to the first one
            }
            cursor2.close();
            return new employee_accounts(cursor2.getString(1), cursor2.getString(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5));
        }

        employee_accounts getEmployeeByEmail (String email){
            // we aren't making any changes so use a readable database, not a writable one.
            SQLiteDatabase db = this.getReadableDatabase();

            // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
            Cursor cursor = db.query(EMPLOYEE_NAME, new String[]{KEY_ID,
                            COL_1, COL_2, COL_3, COL_4, COL_5}, COL_3 + "=?",
                    new String[]{email}, null, null, null, null);
            if (cursor != null) { // If there are non-zero rows returned
                cursor.moveToFirst(); // go to the first one
            }
            cursor.close();
            return new employee_accounts(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        }

        public boolean addEmployee (String name, String phone, String email, String password, String
        postalCode){
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
            if (result == -1) {


                db.close();
                return false;
            } else {
                db.close();

                return true;
            }
        }
//EMPLOYER
        employee_accounts getEmployer ( int id){
            // we aren't making any changes so use a readable database, not a writable one.
            SQLiteDatabase db = this.getReadableDatabase();

            // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
            Cursor cursor2 = db.query(EMPLOYER_NAME, new String[]{KEY_IDD,
                            EMPR_1, EMPR_2, EMPR_3, EMPR_4, EMPR_5}, KEY_IDD + "=?",
                    new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor2 != null) { // If there are non-zero rows returned
                cursor2.moveToFirst(); // go to the first one
            }
            cursor2.close();
            return new employee_accounts(cursor2.getString(1), cursor2.getString(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5));
        }

        employer_accounts getEmployerByEmail (String email_empr){
            // we aren't making any changes so use a readable database, not a writable one.
            SQLiteDatabase db = this.getReadableDatabase();

            // AKA from TABLE_NAME, with details from these columns, I want to select the row with this ID
            Cursor cursor1 = db.query(EMPLOYER_NAME, new String[]{KEY_IDD,
                            EMPR_1, EMPR_2, EMPR_3, EMPR_4, EMPR_5}, EMPR_2 + "=?",
                    new String[]{email_empr}, null, null, null, null);
            if (cursor1 != null) { // If there are non-zero rows returned
                cursor1.moveToFirst(); // go to the first one
            }
            cursor1.close();
            return new employer_accounts(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3), cursor1.getString(4), cursor1.getString(5));
        }

        public boolean addEmployer (EditText companyname, EditText email_empr, EditText phone_empr, EditText
        password_empr, EditText postal_code_empr){
///insert values

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(EMPR_1, String.valueOf(companyname));
            contentValues.put(EMPR_2, String.valueOf(email_empr));
            contentValues.put(EMPR_3, String.valueOf(phone_empr));
            contentValues.put(EMPR_4, String.valueOf(password_empr));
            contentValues.put(EMPR_5, String.valueOf(postal_code_empr));
            long result = db.insert(EMPLOYEE_NAME, null, contentValues);
            //gives -1 result if there is an error
            if (result == -1) {


                db.close();
                return false;
            } else {
                db.close();

                return true;
            }
        }

  /*

        public boolean addJobPost ( int id, String title, String industry, String city){
///insert values
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ID_1, id);
            contentValues.put(TITLE_2, title);
            contentValues.put(INDUSTRY_3, industry);
            contentValues.put(CITY_4, city);
            long result = db.insert(TABLE_NAME, null, contentValues);
            //gives -1 result if there is an error
            if (result == -1) {


                db.close();
                return false;
            } else {
                db.close();

                return true;
            }
        }*/
//when the employee finishes their assessment the addCompletedAssessnt
        public boolean addCompletedAssessment ( int jobPostID, int employeeID){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(CA_EMP_ID, employeeID);
            contentValues.put(CA_JP_ID, jobPostID);
            long result = db.insert(COMPLETED_ASSESSMENTS, null, contentValues);
            //gives -1 result if there is an error
            if (result == -1) {
                db.close();
                return false;
            } else {
                db.close();

                return true;
            }
        }

        //this will get us all the completed assessment = id jobposts+id for employee
        //and the employer would be given the employee id

        ArrayList<Integer> getAllCompletedAssessments ( int jobPostID){
            ArrayList<Integer> employeeList = new ArrayList<>();

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(COMPLETED_ASSESSMENTS, new String[]{CA_EMP_ID, CA_JP_ID}, CA_JP_ID + "=?",
                    new String[]{Integer.toString(jobPostID)}, null, null, null, null);

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


        public Cursor getAllData () {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
            return res;
        }
        //EMPLOYEE
        int update_employee (employee_accounts sa){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COL_1, sa.getIdd());//name
            values.put(COL_2, sa.getPhone());//phone
            values.put(COL_3, sa.getEmail());//email
            values.put(COL_4, sa.getPassword());//password
            values.put(COL_5, sa.getPostal_code());//postalcode

            return db.update(EMPLOYEE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(sa.getIdd())});
        }
        //EMPLOYER
        int update_employer (employer_accounts sa){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(EMPR_1, sa.getid_1());//name
            values.put(EMPR_2, sa.getcompanyname());//phone
            values.put(EMPR_3, sa.getemail_empr());//email
            values.put(EMPR_4, sa.password_empr());//password
            values.put(EMPR_5, sa.postal_code_empr());//postalcode

            return db.update(EMPLOYER_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(sa.getid_1())});
        }


        //EMPLOYEE
        public void delete_employee ( int id){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(EMPLOYEE_NAME, KEY_ID + "=?", new String[]{String.valueOf(id)});
            db.close();
        }
        public void delete_employer ( int id){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(EMPLOYER_NAME, KEY_IDD + "=?", new String[]{String.valueOf(id)});
            db.close();
        }

//CHECK EMPLOYER EMAIL AND PASSWORD
public boolean CheckEr(String email, String password) {

    // array of columns to fetch
    String[] columns = {
            KEY_IDD
    };
    SQLiteDatabase db = this.getReadableDatabase();
    // selection criteria
    String selection = EMPR_2 + " = ?" + " AND " + EMPR_4 + " = ?";

    // selection arguments
    String[] selectionArgs = {email, password};

    // query user table with conditions
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
     */
    Cursor cursor = db.query(EMPLOYER_NAME, //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
        return true;
    }

    return false;
}
//CHECK EMPLOYES EMAIL AND PASSWORD
public boolean CheckEe(String email, String password) {

    // array of columns to fetch
    String[] columns = {
            KEY_IDD
    };
    SQLiteDatabase db = this.getReadableDatabase();
    // selection criteria
    String selection = EMPR_2 + " = ?" + " AND " + EMPR_4 + " = ?";

    // selection arguments
    String[] selectionArgs = {email, password};

    // query user table with conditions
    /**
     * Here query function is used to fetch records from user table this function works like we use sql query.
     * SQL query equivalent to this query function is
     * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
     */
    Cursor cursor = db.query(EMPLOYER_NAME, //Table to query
            columns,                    //columns to return
            selection,                  //columns for the WHERE clause
            selectionArgs,              //The values for the WHERE clause
            null,                       //group the rows
            null,                       //filter by row groups
            null);                      //The sort order

    int cursorCount = cursor.getCount();

    cursor.close();
    db.close();
    if (cursorCount > 0) {
        return true;
    }

    return false;
}





    ///////////HashMap
        // Adding new Job Details
        void insertJobDetails(String TITLE, String INDUSTRY, String CITY){
            //Get the Data Repository in write mode
            SQLiteDatabase db = this.getWritableDatabase();
            //Create a new map of values, where column names are the keys
            ContentValues cValues = new ContentValues();
            cValues.put(TITLE_2, INDUSTRY);
            cValues.put(INDUSTRY_3, INDUSTRY);
            cValues.put(CITY_4, CITY);
            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(TABLE_NAME,null, cValues);
            db.close();
        }

    // Get Job Details
    public ArrayList<HashMap<String, String>> GetJobs(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> jobList = new ArrayList<>();
        String query = "SELECT TITLE, INDUSTRY, CITY FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> job = new HashMap<>();
            job.put("TITLE",cursor.getString(cursor.getColumnIndex(TITLE_2)));
            job.put("INDUSTRY",cursor.getString(cursor.getColumnIndex(INDUSTRY_3)));
            job.put("CITY",cursor.getString(cursor.getColumnIndex(CITY_4)));
            jobList.add(job);
        }
        cursor.close();
        return  jobList;
    }





    // Get Job Details based on userid
    public ArrayList<HashMap<String, String>> GetJobByJobId(int jobid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> jobList = new ArrayList<>();
        String query = "SELECT TITLE, INDUSTRY, CITY FROM "+ TABLE_NAME;
        Cursor cursor = db.query(TABLE_NAME, new String[]{TITLE_2, INDUSTRY_3, CITY_4}, KEY_ID+ "=?",new String[]{String.valueOf(jobid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> job = new HashMap<>();
            job.put("TITLE",cursor.getString(cursor.getColumnIndex(TITLE_2)));
            job.put("INDUSTRY",cursor.getString(cursor.getColumnIndex(INDUSTRY_3)));
            job.put("CITY",cursor.getString(cursor.getColumnIndex(CITY_4)));
            jobList.add(job);
        }
        cursor.close();
        return  jobList;
    }
    // Delete Job Details
    public void DeleteJob(int jobid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID+" = ?",new String[]{String.valueOf(jobid)});
        db.close();
    }
    // Update User Details
    public int UpdateJobDetails(String location, String designation, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(INDUSTRY_3, location);
        cVals.put(CITY_4, designation);
        int count = db.update(TABLE_NAME, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }



    }



