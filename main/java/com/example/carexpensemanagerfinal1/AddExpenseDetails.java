package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddExpenseDetails extends AppCompatActivity {
    private EditText etcarId, etType, etDetails, etAmount, etownerId,etDate;
    private  Button btnback,btnSave;//btnSaveExpCarDetails,btnExpCarBack
    Spinner spExpenseType1;
    ExpenseTable expenseTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense_details);
        expenseTable=new ExpenseTable(this);

        etcarId = (EditText) findViewById(R.id.etCarID2);


        spExpenseType1= (Spinner) findViewById(R.id.spExpenseType);


        etDate = (EditText) findViewById(R.id.etCarExpDate);//
        etDetails = (EditText) findViewById(R.id.etCarExpdetails);//etCarexpAmount
        etownerId= (EditText) findViewById(R.id.etCarUserID);

        etAmount= (EditText) findViewById(R.id.etCarexpAmount);
        btnback=findViewById(R.id.btnExpCarBack);
        btnSave=findViewById(R.id.btnSaveExpCarDetails);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String expenseType=spExpenseType1.getSelectedItem().toString();
                String carid=etcarId.getText().toString();
                String details=etDetails.getText().toString();
                int amount=Integer.parseInt(etAmount.getText().toString());
                String userid=etownerId.getText().toString();
                String date=etDate.getText().toString();
                expenseTable.storeExpenses(new Expense(expenseType,carid,details,amount,userid,date));

            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), UserPanel.class);

                startActivity(intent);


            }
        });





    }
}