package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegisteration extends AppCompatActivity {
    EditText etUseridReg1,etNameReg1,etpwReg1,etUserMobileReg1,etUserEmail1;
    Button btnRegisteration1,btnBackReg1;
    Users_Table myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registeration);

        myTable=new Users_Table(this);


        etUseridReg1=(EditText) findViewById(R.id. etUseridReg);
        etNameReg1=(EditText) findViewById(R.id.etNameReg);
        etpwReg1=(EditText) findViewById(R.id.etpwReg);
        etUserMobileReg1=(EditText) findViewById(R.id.etUserMobileReg);
        etUserEmail1=(EditText) findViewById(R.id.etUserEmail);
        btnBackReg1=(Button) findViewById(R.id.btnBackReg);
        btnRegisteration1=(Button) findViewById(R.id.btnRegisteration);

        btnRegisteration1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String userid = etUseridReg1.getText().toString();
                    String name = etNameReg1.getText().toString();
                    String pw = etpwReg1.getText().toString();
                    String email = etUserEmail1.getText().toString();
                    String mob = etUserMobileReg1.getText().toString();
                    int mobileNo = Integer.parseInt(mob);
                    boolean result = myTable.insertData(userid, name, pw, mobileNo, email);

                    if (result) {
                        Toast.makeText(UserRegisteration.this, " User is registered now ", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(UserRegisteration.this, " Error! User is not register now ", Toast.LENGTH_SHORT).show();


                    }
                }
                catch(Exception exp){

                    Toast.makeText(UserRegisteration.this, " Error!"+exp.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }





            }
        });

        btnBackReg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);

                startActivity(intent);

            }
        });


    }
}