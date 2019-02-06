package com.example.muktamayee.raksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Emergency_Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency__contacts);
        Button register =  findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data db = new data(getApplicationContext());
                EditText phone1 = findViewById(R.id.phone1);
                EditText phone2 = findViewById(R.id.phone2);
                EditText phone3 = findViewById(R.id.phone3);
                EditText phone4 = findViewById(R.id.phone4);
                EditText phone5 = findViewById(R.id.phone5);
                Emer emer;
                emer = new Emer();
                emer.setPhone1(phone1.getText().toString());
                emer.setPhone2(phone2.getText().toString());
                emer.setPhone3(phone3.getText().toString());
                emer.setPhone4(phone4.getText().toString());
                emer.setPhone5(phone5.getText().toString());

                if(emer.phone1.length()>0 && emer.phone2.length()>0 && emer.phone3.length()>0 && emer.phone4.length()>0 && emer.phone5.length()>0)
                {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    db.addEmer(emer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"cannot leave an empty field",Toast.LENGTH_LONG);
                }
            }
        });
    }
}

