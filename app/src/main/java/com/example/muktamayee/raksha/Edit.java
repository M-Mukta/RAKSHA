package com.example.muktamayee.raksha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Edit extends AppCompatActivity {

    List<String> contactList1;
    data db;
    Emer emer=new Emer();
    Emer e=new Emer();
    EditText phone1;
    EditText phone2;
    EditText phone3;
    EditText phone4;
    EditText phone5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        db =new data(getApplicationContext());
        phone1 = findViewById(R.id.uphone1);
        phone2 = findViewById(R.id.uphone2);
        phone3 = findViewById(R.id.uphone3);
        phone4 = findViewById(R.id.uphone4);
        phone5 = findViewById(R.id.uphone5);

        contactList1 = db.getAllContacts();
        phone1.setText(contactList1.get(0));
        phone2.setText(contactList1.get(1));
        phone3.setText(contactList1.get(2));
        phone4.setText(contactList1.get(3));
        phone5.setText(contactList1.get(4));
        e.setPhone1(phone1.getText().toString());
        e.setPhone2(phone2.getText().toString());
        e.setPhone3(phone3.getText().toString());
        e.setPhone4(phone4.getText().toString());
        e.setPhone5(phone5.getText().toString());
        Button update = findViewById(R.id.update);



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void click()
    {
        emer.setPhone1(phone1.getText().toString());
        emer.setPhone2(phone2.getText().toString());
        emer.setPhone3(phone3.getText().toString());
        emer.setPhone4(phone4.getText().toString());
        emer.setPhone5(phone5.getText().toString());
        db.updateEmer(emer,e);
    }
}
