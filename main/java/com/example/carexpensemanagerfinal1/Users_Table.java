package com.example.carexpensemanagerfinal1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Users_Table extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "UsersDB.db";
    public static final String TABLE_NAME = "User_table";

    public static final String COL_1 = "userid";
    public static final String COL_2 = "name";
    public static final String COL_3 = "password";
    public static final String COL_4 = "mobile";
    public static final String COL_5 = "email";

    public Users_Table(Context context)//constructor
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (userid TEXT PRIMARY KEY,name TEXT,password TEXT,mobile INTEGER,email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String userid,String name, String pw, int mobileNo, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, userid);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, pw);
        contentValues.put(COL_4, mobileNo);
        contentValues.put(COL_5, email);

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

    public boolean checkUserExist(String userid, String password) {//UserID ,Password
        String[] columns = {"userid"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "userid=? and password = ?";
        String[] selectionArgs = {userid, password};

        Cursor cursor = db.query("User_table", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}