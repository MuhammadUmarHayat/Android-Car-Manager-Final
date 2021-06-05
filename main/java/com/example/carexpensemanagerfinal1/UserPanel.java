package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserPanel extends AppCompatActivity
{
    TextView tvResult11;
    Button btnAddCarDetails1,btnViewCarGallary1,btnCalculate1,btnAddCarReadingDetails1,btnViewCarReadings1,btnAddCarExpenseDetails1,btnViewCarExpense1;
Car_Readings_Table car_readings_table;
ExpenseTable expenseTable;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

        expenseTable =new ExpenseTable(this);
        car_readings_table=new Car_Readings_Table(this);


        btnAddCarDetails1=(Button) findViewById(R.id.btnAddCarDetails);
        btnViewCarGallary1=(Button) findViewById(R.id.btnViewCarGallary);

        btnAddCarReadingDetails1=(Button) findViewById(R.id.btnAddCarReadingDetails);
        btnViewCarReadings1 =(Button) findViewById(R.id.btnViewCarReadings);
        btnAddCarExpenseDetails1=(Button) findViewById(R.id.btnAddCarExpenseDetails);
        btnViewCarExpense1 =(Button) findViewById(R.id.btnViewCarExpense);
        btnCalculate1=(Button) findViewById(R.id.btnCalculate);
        tvResult11=findViewById(R.id.tvResult1);

        
try {
    Reminder();
}
catch (Exception exp)
{



}



btnCalculate1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent page = new Intent(getBaseContext(), AverageCalculator.class);

        startActivity(page);


    }
});


        btnAddCarDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(getBaseContext(), CarDetails.class);

                startActivity(page);


            }
        });
        btnViewCarGallary1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    Intent page = new Intent(getBaseContext(), CarDetails.class);

                    startActivity(page);
                }
                catch (Exception exp){
                    tvResult11.setText(exp.getMessage());

                }




            }
        });

        btnAddCarReadingDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(getBaseContext(), AddCarReadings.class);

                startActivity(page);



            }
        });
        btnViewCarReadings1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try{
                    ViewAllCarReadings();
                }
                catch (Exception exp){
                    tvResult11.setText(exp.getMessage());

                }





            }
        });
        btnAddCarExpenseDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent page = new Intent(getBaseContext(), AddExpenseDetails.class);

                startActivity(page);



            }
        });
        btnViewCarExpense1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try{
                    ViewAllExpenses();
                }
                catch (Exception exp){
                    tvResult11.setText(exp.getMessage());

                }





            }
        });


    }//end on create


    private void Reminder()
    {

        Cursor res = expenseTable.getReminder();
        if(res.getCount() == 0) {
            // show message
            showMessage("Rimnder ","Nothing is found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {

            buffer.append("Carid :" + res.getString(0) + "\n");
            buffer.append("You had changed your engine oil on " + res.getString(3) + "\n");

        }//while
        showMessage("Car oil change reminder  ",buffer.toString());

    }




    private void ViewAllCarReadings()
    {

        Cursor res = car_readings_table.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {

            buffer.append("carid :" + res.getString(0) + "\n");
            buffer.append("tripmeter :" + res.getString(1) + "\n");
            buffer.append("Odometer :" + res.getString(2) + "\n");
            buffer.append("Reading Date :" + res.getString(3) + "\n");

        }//while
        showMessage("Car Readings ",buffer.toString());

    }
    private void ViewAllExpenses()
    {

        Cursor res = expenseTable.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
            buffer.append("Expense ID:" + res.getString(0) + "\n");
            buffer.append("ExpenseType :" + res.getString(1) + "\n");
            buffer.append("Carid:" + res.getString(2) + "\n");
            buffer.append("Amount :" + res.getString(3) + "\n");
            buffer.append("Expense By :" + res.getString(4) + "\n");
            buffer.append("Date :" + res.getString(5) + "\n");
        }//while
        showMessage("All Expenses ",buffer.toString());

    }









    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }



}