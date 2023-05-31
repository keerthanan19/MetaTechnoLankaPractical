package com.example.metatechnolankapractical.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class db_manager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Assignment.db";
    private static final int DATABASE_VERSION = 1;

    db_manager(Context context){
        super(context,DATABASE_NAME ,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(db_tables.CREATE_TABLE_DATA);
        }catch (Exception e){
            Log.e(db_manager.class.getSimpleName(),e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        switch (oldVersion){
            default:
        }
    }
}
