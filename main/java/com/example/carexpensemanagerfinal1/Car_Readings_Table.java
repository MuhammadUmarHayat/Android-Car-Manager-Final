package com.example.carexpensemanagerfinal1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Car_Readings_Table  extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "CarReadingsDB.db";
    public static final String TABLE_NAME = "CarReadings_table";
    public static final String COL_1 = "carid";
    public static final String COL_2 = "tripmeter";
    public static final String COL_3 = "Odometer";
    public static final String COL_4 = "Date";

    public Car_Readings_Table(Context context)//constructor
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (carid TEXT ,tripmeter TEXT,Odometer TEXT,date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String carid,String tripmeter, String Odometer,  String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, carid);
        contentValues.put(COL_2, tripmeter);
        contentValues.put(COL_3, Odometer);
        contentValues.put(COL_4, date);


        long result = db.insert(TABLE_NAME, null, contentValues);//insert
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


}