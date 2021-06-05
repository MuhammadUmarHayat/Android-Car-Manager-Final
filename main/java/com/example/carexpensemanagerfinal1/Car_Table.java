package com.example.carexpensemanagerfinal1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Car_Table extends SQLiteOpenHelper
{
    Context context;
    private static String DATABASE_NAME="CarDetailsDb.db";
    private static int DATABASE_VERSION=2;
    //String carId, String model, String capacity, String colour, String ownerId, Bitmap image)
    private static String createTableQuery="create table Cartable(id INTEGER PRIMARY KEY,carId TEXT ,model TEXT,capacity TEXT,colour TEXT,ownerId TEXT,image BLOB)";


    public Car_Table(Context context)
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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS Cartable" );
        // Create tables again
        onCreate(db);
    }
    //String carId, String model, String capacity, String colour, String ownerId, byte[] image
    public void addContacts(Car myCar)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put("carId",myCar.getCarId());
        values.put("model",myCar.getModel());
        values.put("capacity",myCar.getCapacity());
        values.put("colour",myCar.getColour());
        values.put("ownerId",myCar.getOwnerId());
        values.put("image",myCar.getImage());
        db.insert("Cartable", null, values);
        db.close();
    }
    public List<Car> getAllContacts() {
        List<Car> contactList = new ArrayList<Car>();
        // Select All Query
        String selectQuery = "SELECT  * FROM Cartable" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //String carId, String model, String capacity, String colour, String ownerId, byte[] image
                Car car = new Car();
                car.setId(Integer.parseInt(cursor.getString(0)));
                car.setCarId(cursor.getString(1));
                car.setModel(cursor.getString(2));
                car.setCapacity(cursor.getString(3));
                car.setColour(cursor.getString(4));
                car.setOwnerId(cursor.getString(5));
                car.setImage(cursor.getBlob(6));




                //   contact.set_img(cursor.getBlob(2));


                // Adding car to list
                contactList.add(car);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }






}
