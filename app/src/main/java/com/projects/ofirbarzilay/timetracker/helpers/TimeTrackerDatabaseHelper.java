package com.projects.ofirbarzilay.timetracker.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ofir.Barzilay on 21/12/2014.
 */
public class TimeTrackerDatabaseHelper extends SQLiteOpenHelper {

    public static final String TIME_COLUMN = "time";
    public static final String TIMETRACKER_DB = "timetracker.db";
    public static final int VERSION = 5;
    public static final String TABLE_NAME = "timerecords";
    public static final String NOTES_COLUMN = "notes";
    public static final String TIMETRACKER_COLUMN_ID = "_id";
    private final SQLiteDatabase writableDatabase;

    public TimeTrackerDatabaseHelper(Context context) {
        super(context, TIMETRACKER_DB, null, VERSION);
        writableDatabase = getWritableDatabase();
    }

    public void saveTimeRecord(String time, String notes) {
//        writableDatabase.execSQL(
//                "INSERT INTO " + TABLE_NAME + " " +
//                        "(" + TIME_COLUMN + ", " + NOTES_COLUMN + ")" +
//                        " VALUES ('" + time + "' , '" + notes + "')"
//        );

        ContentValues contentValues = new ContentValues();
        contentValues.put(TIME_COLUMN, time);
        contentValues.put(NOTES_COLUMN, notes);
        writableDatabase.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(
                "CREATE TABLE " + TABLE_NAME + " " +
                        "(" + TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, " + TIME_COLUMN + " TEXT, " + NOTES_COLUMN + " TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    public Cursor getAllTimeRecords() {
        return writableDatabase.rawQuery(
                "select * from " + TABLE_NAME,
                null
        );
    }
}
