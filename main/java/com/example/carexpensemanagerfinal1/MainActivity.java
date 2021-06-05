package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etuserid1,etPw1;
    Button btnLogin1,btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuserid1=(EditText) findViewById(R.id.etUserid);
        etPw1=(EditText) findViewById(R.id.etpw);
        btnLogin1=(Button) findViewById(R.id.btnLogin);

        btnReg=(Button) findViewById(R.id.btnReg);

        Users_Table mytable=new Users_Table(this);

        btnReg .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), UserRegisteration.class);
                startActivity(intent);

            }
        });

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userid = etuserid1.getText().toString();
                String password = etPw1.getText().toString();

                if (userid.equals("") && password.equals("")) {
                    Toast.makeText(MainActivity.this, "Error: Please enter correct data", Toast.LENGTH_SHORT).show();

                } else {

                    if (mytable.checkUserExist(userid, password))
                    {

                        Intent intent = new Intent(getBaseContext(), UserPanel.class);

                        startActivity(intent);


                    }
                    else
                    {

                        Toast.makeText(MainActivity.this, "Error: userid or password is wrong ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}