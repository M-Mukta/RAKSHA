package com.example.muktamayee.raksha;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    //private static final String TABLE_USER = "user";
    private static final String TABLE_EMER = "Emergency";

    // User Table Columns names
    //private static final String COLUMN_USER_ADDRESS = "user_address";
    //private static final String COLUMN_USER_NAME = "user_name";
    //private static final String COLUMN_USER_EMAIL = "user_email";
    //private static final String COLUMN_USER_PASSWORD = "user_password";
    //private static final String COLUMN_USER_PHONENUMBER = "user_phonenumber";
    private static final String COLUMN_EMER_PHONENUMBER = "Emergency_phonenumber";

    // create table sql query
    /*private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_PHONENUMBER + " INTEGER PRIMARY KEY ," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_ADDRESS + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";*/

    private String CREATE_EMER_TABLE = "CREATE TABLE " + TABLE_EMER + "("
            + COLUMN_EMER_PHONENUMBER + " INTEGER " + ")";


    // drop table sql query
    //private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_EMER_TABLE = "DROP TABLE IF EXISTS " + TABLE_EMER;

    /**
     * Constructor
     *
     * @param context
     */
    public data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(CREATE_USER_TABLE);
       db.execSQL(CREATE_EMER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        //db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_EMER_TABLE);
        // Create tables again
        onCreate(db);

    }

    /*public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_ADDRESS, user.getAddress());
        values.put(COLUMN_USER_PHONENUMBER, user.getPhonenumber());
        db.insert(TABLE_USER, null, values);
        db.close();
    }*/
    public void addEmer(Emer emer){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values1 = new ContentValues();
            values1.put(COLUMN_EMER_PHONENUMBER, emer.getPhone1());
            db.insert(TABLE_EMER, null, values1);
            values1.put(COLUMN_EMER_PHONENUMBER, emer.getPhone2());
            db.insert(TABLE_EMER, null, values1);
            values1.put(COLUMN_EMER_PHONENUMBER, emer.getPhone3());
            db.insert(TABLE_EMER, null, values1);
            values1.put(COLUMN_EMER_PHONENUMBER, emer.getPhone4());
            db.insert(TABLE_EMER, null, values1);
            values1.put(COLUMN_EMER_PHONENUMBER, emer.getPhone5());
            // Inserting Row
            db.insert(TABLE_EMER, null, values1);
            db.close();
    }
    public void updateEmer(Emer emer,Emer e) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMER_PHONENUMBER, emer.getPhone1());
        db.update(TABLE_EMER, values, COLUMN_EMER_PHONENUMBER + " = ?",
                new String[]{String.valueOf(e.getPhone1())});
        values.put(COLUMN_EMER_PHONENUMBER, emer.getPhone2());
        db.update(TABLE_EMER, values, COLUMN_EMER_PHONENUMBER+ " = ?",
                new String[]{String.valueOf(e.getPhone2())});
        values.put(COLUMN_EMER_PHONENUMBER, emer.getPhone3());
        db.update(TABLE_EMER, values, COLUMN_EMER_PHONENUMBER + " = ?",
                new String[]{String.valueOf(e.getPhone3())});
        values.put(COLUMN_EMER_PHONENUMBER, emer.getPhone4());
        db.update(TABLE_EMER, values, COLUMN_EMER_PHONENUMBER + " = ?",
                new String[]{String.valueOf(e.getPhone4())});
        values.put(COLUMN_EMER_PHONENUMBER, emer.getPhone5());
        db.update(TABLE_EMER, values, COLUMN_EMER_PHONENUMBER + " = ?",
                new String[]{String.valueOf(e.getPhone5())});
        db.close();
    }
/*
    /**
     * This method is to delete user record
     *
     * @param user
     *
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }*/

    // code to get all contacts in a list view
    public List<String> getAllContacts() {
        List<String> contactList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Emer emer = new Emer();
                emer.setPhone1(cursor.getString(0));
                String ph=emer.getPhone1();
                contactList.add(ph);
            } while (cursor.moveToNext());
        }
        return contactList;
    }
       /* public boolean checkUser1(String phonenumber, String password){
            // array of columns to fetch
            String[] columns = {
                    COLUMN_USER_PHONENUMBER
            };
            SQLiteDatabase db = this.getReadableDatabase();
            // selection criteria
            String selection = COLUMN_USER_PHONENUMBER + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

            // selection arguments
            String[] selectionArgs = {phonenumber, password};

            // query user table with conditions
            /**
             * Here query function is used to fetch records from user table this function works like we use sql query.
             * SQL query equivalent to this query function is
             * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
             */
       /*
            Cursor cursor = db.query(TABLE_USER, //Table to query
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
        }*/
    }




