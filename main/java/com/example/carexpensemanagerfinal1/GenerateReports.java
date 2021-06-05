package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class GenerateReports extends AppCompatActivity
{
    EditText editTextDateReport1;
Spinner spExpType;
Button btnShowAll,btnShowExpRep,btnDatewiseRep;
ExpenseTable expenseTable;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_reports);
        spExpType=findViewById(R.id.spExpTypeRep);
      //  buttonAllRep,buttonExReport
        btnShowAll=findViewById(R.id.buttonAllRep);
        btnShowExpRep=findViewById(R.id.buttonExReport);
        btnDatewiseRep=findViewById(R.id.buttonExReport2);
        editTextDateReport1=findViewById(R.id.editTextDateReport);


        btnShowAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ViewAllExpenses();
            }
        });

        btnShowExpRep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String exType=spExpType.getSelectedItem().toString();



                ViewExpensesType(exType);


            }
        });
        btnDatewiseRep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String date=editTextDateReport1.getText().toString();
                ViewExpensesByDate( date);


            }
        });


    }//end on create


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
            buffer.append("expense ID:" + res.getString(0) + "\n");
            buffer.append("expenseType :" + res.getString(1) + "\n");
            buffer.append("carid:" + res.getString(2) + "\n");
            buffer.append("amount :" + res.getString(3) + "\n");
            buffer.append("user ID :" + res.getString(4) + "\n");
            buffer.append("Date :" + res.getString(5) + "\n");

        }//while
        showMessage("All Expenses ",buffer.toString());

    }


  private  void   ViewExpensesType(String exType)
  {
      Cursor res = expenseTable.getExpByType(exType);
      if(res.getCount() == 0) {
          // show message
          showMessage("Error","Nothing found");
          return;
      }


      StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
      while (res.moveToNext()) {
          buffer.append("expense ID:" + res.getString(0) + "\n");
          buffer.append("expenseType :" + res.getString(1) + "\n");
          buffer.append("carid:" + res.getString(2) + "\n");
          buffer.append("amount :" + res.getString(3) + "\n");
          buffer.append("user ID :" + res.getString(4) + "\n");
          buffer.append("Date :" + res.getString(5) + "\n");

      }//while
      showMessage("All Expenses ",buffer.toString());


    }
    private  void   ViewExpensesByDate(String date)
    {
        Cursor res =expenseTable.getExpByDate(date) ;
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }


        StringBuffer buffer = new StringBuffer();
//(String carid,String tripmeter, String Odometer,  String date)
        while (res.moveToNext()) {
            buffer.append("expense ID:" + res.getString(0) + "\n");
            buffer.append("expenseType :" + res.getString(1) + "\n");
            buffer.append("carid:" + res.getString(2) + "\n");
            buffer.append("amount :" + res.getString(3) + "\n");
            buffer.append("user ID :" + res.getString(4) + "\n");
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
    public boolean onCreateOptionsMenu(Menu menu)
    {

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }



}