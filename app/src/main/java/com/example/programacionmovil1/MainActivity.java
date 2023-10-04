package com.example.programacionmovil1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programacionmovil1.configuracion.Sqlliteconecxion;
import com.example.programacionmovil1.configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombre,apellido,edad,email;

    Button btneprocesar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtnombre);
        apellido = (EditText) findViewById(R.id.txtapellido);
        edad = (EditText) findViewById(R.id.txtedad);
        email = (EditText) findViewById(R.id.txtcorreo);
        btneprocesar = (Button) findViewById(R.id.btnprocesar);

        btneprocesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),nombre.getText().toString()+" "+apellido.getText().toString(), Toast.LENGTH_LONG).show();
                addPerson();
                Intent intentcreate = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intentcreate);
            }
        });
    }

    private void addPerson() {
        try {
            Sqlliteconecxion conecxion = new Sqlliteconecxion(this, Transacciones.namedb, null, 1);
            SQLiteDatabase db = conecxion.getWritableDatabase();

            ContentValues valores = new ContentValues();

            valores.put(Transacciones.nombre, nombre.getText().toString());
            valores.put(Transacciones.apellido, apellido.getText().toString());
            valores.put(Transacciones.edad, edad.getText().toString());
            valores.put(Transacciones.correo, email.getText().toString());


            long Result = db.insert(Transacciones.Tabla, Transacciones.id, valores);

            Toast.makeText(this, getString(R.string.Respuesta), Toast.LENGTH_LONG).show();
            db.close();
        }
        catch (Exception e) {
            Toast.makeText(this, getString(R.string.Error), Toast.LENGTH_LONG).show();
        }
    }

}