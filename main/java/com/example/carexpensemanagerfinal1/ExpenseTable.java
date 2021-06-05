package com.example.carexpensemanagerfinal1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTable extends SQLiteOpenHelper
{

    Context context;
    private static String DATABASE_NAME="CarExpenseDb.db";
    private static int DATABASE_VERSION=2;

    private static String createTableQuery="create table Expensetable(expenseid INTEGER PRIMARY KEY AUTOINCREMENT ,expenseType TEXT ,carid TEXT,details TEXT,amount INTEGER,userid TEXT,date TEXT)";
    public ExpenseTable(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=  context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(createTableQuery);
        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public void storeExpenses(Expense expense)
    {
        try
        {
            //String carId, String model, String capacity, String colour, String ownerId, Bitmap image)
            SQLiteDatabase objectSqLiteDatabase=this.getWritableDatabase();
            ContentValues objectValues=new ContentValues();//imageInfo(imageName TEXT ,image BLOB)
            objectValues.put("expenseType",expense.getExpenseType());
            objectValues.put("carid",expense.getCarid());
            objectValues.put("amount",expense.getAmount());
            objectValues.put("date",expense.getDate());
            objectValues.put("details",expense.getDetails());
            objectValues.put("userid",expense.getUserid());

            long result=objectSqLiteDatabase.insert("Expensetable",null,objectValues);
            if(result!=-1)
            {
                Toast.makeText(context,"Data is saved",Toast.LENGTH_SHORT).show();
                objectSqLiteDatabase.close();
            }
            else{
                Toast.makeText(context,"Data is not saved",Toast.LENGTH_SHORT).show();

            }


        }
        catch(Exception exp)
        {

            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }

    public Cursor getAllData()
    {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res = db.rawQuery("select * from Expensetable" , null);
    return res;
}

    public Cursor getExpByType(String expenseType)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from Expensetable where expenseType='"+expenseType+"'" , null);
        return res;
    }
    public Cursor getExpByDate(String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from Expensetable where date='"+date+"'" , null);
        return res;
    }


    public Cursor getReminder()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from Expensetable where expenseType='Change Oil' LIMIT 1" , null);
        return res;
    }

    public ArrayList<Expense> getAllExpenses()
    {
        try
        {

            SQLiteDatabase objectSqliteDatabase=this.getReadableDatabase();
            ArrayList<Expense> objectModelClassList=new ArrayList<>();
            Cursor objectCursor=objectSqliteDatabase.rawQuery("select * from Expensetable ",null);
            if(objectCursor.getCount()!=0)
            {
                while(objectCursor.moveToNext())
                {
                    //String expenseType, String carid, String details, int amount, String userid, String date, Bitmap image) {
                    String expenseType=objectCursor.getString(0);

                    String carid=objectCursor.getString(1);
                    String details=objectCursor.getString(2);
                    String a=objectCursor.getString(3);
                    int amount=Integer.parseInt(a);

                    String userid=objectCursor.getString(4);
                    String date=objectCursor.getString(5);






                    objectModelClassList.add(new Expense(expenseType,carid,details,amount,userid,date));

                }
                return objectModelClassList;
            }
            else{
                Toast.makeText(context,"value does not exist in database ",Toast.LENGTH_SHORT).show();
                return null;
            }
        }
        catch(Exception exp)
        {
            Toast.makeText(context,exp.getMessage(),Toast.LENGTH_SHORT).show();


            return null;
        }


    }

    public List<String> getAllSects()
    {
        List<String> list = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM Expensetable";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));//adding 2nd column data
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();
        // returning lables
        return list;
    }




}
