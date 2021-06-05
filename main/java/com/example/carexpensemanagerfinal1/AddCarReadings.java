package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCarReadings extends AppCompatActivity
{
    EditText etCarID3A,etTripMeterA,etOdometerA,etReadingDateA;
    Button btnSave,btnBack;
    Car_Readings_Table myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_readings);

        etCarID3A= (EditText) findViewById(R.id.etCarID3);
        etTripMeterA= (EditText) findViewById(R.id.etTripMeter);
        etOdometerA= (EditText) findViewById(R.id.etOdometer);
        etReadingDateA= (EditText) findViewById(R.id.etReadingDate);
        btnSave=(Button) findViewById(R.id.btnSaveReadings);
        btnBack=(Button) findViewById(R.id.btnBackReg);
        myTable=new Car_Readings_Table(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String carid=etCarID3A.getText().toString();
                String tripMeter=etTripMeterA.getText().toString();

                String odoMeter=etOdometerA.getText().toString();
                String ReadingDate=etReadingDateA.getText().toString();


                Boolean result=myTable.insertData(carid,tripMeter,odoMeter,ReadingDate);


                if(result)
                {
                    Toast.makeText(AddCarReadings.this, " Record is saved now ", Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(AddCarReadings.this, " Error!Record is not saved now ", Toast.LENGTH_SHORT).show();


                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(getBaseContext(), UserPanel.class);

                startActivity(intent);


            }
        });



    }
}