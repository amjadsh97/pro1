package com.example.com.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseSQLite extends SQLiteOpenHelper  {

    public static final String DATABASE_NAME = "Grouplist.db";
    public static final int DATABASE_VERSION = 1;

    public DataBaseSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//         String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
//                GroupContantDB.GroupEntry.TABLE_NAME + " (" +
//                 GroupContantDB.GroupEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                 GroupContantDB.GroupEntry.COLUMN_NAME + " TEXT NOT NULL,"+
//                GroupContantDB.GroupEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
//                ");";

        String CREATE_TABLE = "CREATE TABLE " + GroupContantDB.GroupEntry.TABLE_NAME + "("
                + GroupContantDB.GroupEntry._ID + " INTEGER PRIMARY KEY," + GroupContantDB.GroupEntry.COLUMN_NAME
                + " TEXT);";

        sqLiteDatabase.execSQL(CREATE_TABLE);


//        ContentValues values = new ContentValues();
//        values.put(GroupContantDB.GroupEntry.COLUMN_NAME, "yones"); // Account Title
//        sqLiteDatabase.insert(DATABASE_NAME, null, values);
//        sqLiteDatabase.close(); // Closing database connection
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GroupContantDB.GroupEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
