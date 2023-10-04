package com.example.programacionmovil1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    Button btncrate,btnlista;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btncrate = (Button) findViewById(R.id.btncrear);
        btnlista = (Button) findViewById(R.id.btnlista);



        btncrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentcreate);
            }
        });

        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(),Activitylist.class);
                startActivity(intentcreate);
            }
        });
    }
}