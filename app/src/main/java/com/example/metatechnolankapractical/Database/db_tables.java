package com.example.metatechnolankapractical.Database;

public class db_tables {

    static final String TABLE_NAME_DATA = "Data";

    public static final String _ID  = "_id";
    public static String TITTLE = "title";
    public static String HEDLINE = "headline";
    public static String IMAGE = "image";
    public static String GRADIENT_COLOR= "gradientColors";
    public static String DESCRIPTION= "description";
    public static String NUTRITION= "nutrition";

    static final String CREATE_TABLE_DATA = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DATA
            + " ( " +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            HEDLINE + " TEXT, " +
            IMAGE + " TEXT, " +
            GRADIENT_COLOR  + " TEXT, " +
            DESCRIPTION + " TEXT, " +
            NUTRITION + " TEXT" +
            ");";

}
