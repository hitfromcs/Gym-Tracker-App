package com.example.gymtrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GymTracker.db";
    private static final int DATABASE_VERSION = 1;

    // User table
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Workout table
    private static final String TABLE_WORKOUT = "workouts";
    private static final String COLUMN_WORKOUT_USERNAME = "username";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_PUSHUPS = "pushups";
    private static final String COLUMN_BENCHPRESS = "benchpress";
    private static final String COLUMN_WEIGHT = "weight";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);

        String createWorkoutTable = "CREATE TABLE " + TABLE_WORKOUT + " (" +
                COLUMN_WORKOUT_USERNAME + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_PUSHUPS + " INTEGER, " +
                COLUMN_BENCHPRESS + " INTEGER, " +
                COLUMN_WEIGHT + " REAL)";
        db.execSQL(createWorkoutTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT);
        onCreate(db);
    }

    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE username=? AND password=?",
                new String[]{username, password});

        return cursor.getCount() > 0;
    }

    public boolean saveWorkout(String username, String date, int pushups, int benchpress, double weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORKOUT_USERNAME, username);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_PUSHUPS, pushups);
        values.put(COLUMN_BENCHPRESS, benchpress);
        values.put(COLUMN_WEIGHT, weight);

        long result = db.insert(TABLE_WORKOUT, null, values);
        return result != -1;
    }

    public Cursor getWorkoutData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_WORKOUT + " WHERE username=?", new String[]{username});
    }
}
