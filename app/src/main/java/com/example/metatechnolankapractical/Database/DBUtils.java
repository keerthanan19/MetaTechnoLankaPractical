package com.example.metatechnolankapractical.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.metatechnolankapractical.Object.Data;

import java.util.ArrayList;

public class DBUtils {

    private static db_manager db_manager;
    private static final String TAG = "DBUtils";

    public static boolean insert_data (Data data, Context context){
        boolean isSuccess = false ;
        db_manager = new db_manager(context);
        try (SQLiteDatabase db = db_manager.getWritableDatabase()){

            ContentValues cv = new ContentValues();
            cv.put(db_tables.HEDLINE,data.getDescription());
            cv.put(db_tables.TITTLE,data.getDescription());
            cv.put(db_tables.IMAGE,data.getDescription());
            cv.put(db_tables.GRADIENT_COLOR,data.getDescription());
            cv.put(db_tables.DESCRIPTION,data.getDescription());
            cv.put(db_tables.NUTRITION,data.getDescription());

            try {
                long rawCount = db.insertOrThrow(db_tables.TABLE_NAME_DATA,null,cv);
                if (rawCount != -1){
                    isSuccess = true;
                }else {
                    Log.e(TAG,"insert_data" + "insert failed");
                    isSuccess = false;
                }
            }catch (Exception ie){
                try {
                    long rawCount = db.replaceOrThrow(db_tables.TABLE_NAME_DATA,null,cv);
                    if (rawCount != -1){
                        isSuccess = true;
                    }else {
                        Log.e(TAG,"insert_data" + "replaced failed");
                        isSuccess = false;
                    }
                }catch (Exception iee){
                    Log.e(TAG,"insert_data " + iee.getMessage() );
                }
            }
        }catch (Exception e){
            Log.e(TAG,"insert_data " + e.getMessage() );
        }

        return isSuccess;
    }

    public static ArrayList<Data> getAllData (Context context){
        ArrayList<Data> dataArrayList = new ArrayList<>();
        db_manager = new db_manager(context);
        Cursor cursor;

        StringBuilder query = new StringBuilder("SELECT * FROM " + db_tables.TABLE_NAME_DATA);
        try (SQLiteDatabase db = db_manager.getWritableDatabase()){
            cursor = db.rawQuery(query.toString(),null);
            if(cursor.moveToFirst()) {
                do {
                    Data data = new Data();

                    data.setID(context.getString(cursor.getColumnIndex(db_tables._ID)));
                    data.setTitle(context.getString(cursor.getColumnIndex(db_tables.TITTLE)));
                    data.setHeadline(context.getString(cursor.getColumnIndex(db_tables.HEDLINE)));
                    data.setImage(Drawable.createFromPath(context.getString(cursor.getColumnIndex(db_tables.IMAGE))));
                    data.setGradientColors(context.getString(cursor.getColumnIndex(db_tables.GRADIENT_COLOR)));
                    data.setDescription(context.getString(cursor.getColumnIndex(db_tables.DESCRIPTION)));
                    data.setNutrition(context.getString(cursor.getColumnIndex(db_tables.NUTRITION)));

                    dataArrayList.add(data);
                } while (cursor.moveToNext());
            }

            return dataArrayList;
        }catch (Exception exception){
            Log.e(TAG, "getAllData" + exception.getMessage());
        }

        return dataArrayList;
    }

    public static Data getAllDataByID (Context context, String ID){
        Data data = new Data();
        db_manager = new db_manager(context);
        Cursor cursor;

        StringBuilder query = new StringBuilder("SELECT * FROM " + db_tables.TABLE_NAME_DATA + " where "
         + db_tables._ID + "='" + ID + "'");
        try (SQLiteDatabase db = db_manager.getWritableDatabase()){
            cursor = db.rawQuery(query.toString(),null);
            if(cursor.moveToFirst()) {
                do {


                    data.setID(context.getString(cursor.getColumnIndex(db_tables._ID)));
                    data.setTitle(context.getString(cursor.getColumnIndex(db_tables.TITTLE)));
                    data.setHeadline(context.getString(cursor.getColumnIndex(db_tables.HEDLINE)));
                    data.setImage(Drawable.createFromPath(context.getString(cursor.getColumnIndex(db_tables.IMAGE))));
                    data.setGradientColors(context.getString(cursor.getColumnIndex(db_tables.GRADIENT_COLOR)));
                    data.setDescription(context.getString(cursor.getColumnIndex(db_tables.DESCRIPTION)));
                    data.setNutrition(context.getString(cursor.getColumnIndex(db_tables.NUTRITION)));

                } while (cursor.moveToNext());
            }

            return data;
        }catch (Exception exception){
            Log.e(TAG, "getAllData" + exception.getMessage());
        }

        return data;
    }

    public static void deleteAllData(Context context){
        db_manager = new db_manager(context);
        SQLiteDatabase db = db_manager.getReadableDatabase();
        db.execSQL("DELETE FROM " + db_tables.TABLE_NAME_DATA);

    }

}
