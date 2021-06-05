package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AverageCalculator extends AppCompatActivity {
    Button btnCalculateFuel1,btnAvgBack1;
    EditText etFuel,etKm;
    TextView tvResult;//textViewResult

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        btnCalculateFuel1=findViewById(R.id.btnCalculateFuel);

        btnAvgBack1=findViewById(R.id.btnAvgBack);
        etFuel=findViewById(R.id.etAvgFuel);
        etKm=findViewById(R.id.etAvgKm);

        btnCalculateFuel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    double fuel=Double.parseDouble(etFuel.getText().toString());
                    double km=Double.parseDouble(etKm.getText().toString());

                    double result=km/fuel;

                    tvResult.setText("Average : "+result);


                }
                catch(Exception exp){


                }
            }
        });
        btnAvgBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent page = new Intent(getBaseContext(), UserPanel.class);

                startActivity(page);

            }
        });





    }
}