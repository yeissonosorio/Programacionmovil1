package com.example.programacionmovil1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.programacionmovil1.Modelo.Personas;
import com.example.programacionmovil1.configuracion.Sqlliteconecxion;
import com.example.programacionmovil1.configuracion.Transacciones;

import java.util.ArrayList;

public class Activitylist extends AppCompatActivity {

    Sqlliteconecxion conecxion;

    ListView listView;

    ArrayList<Personas> lisperson;


    ArrayList<String> AregloPersoans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitylist);

        try{
            conecxion= new Sqlliteconecxion(this,Transacciones.namedb,null,1);
            listView=  (ListView) findViewById(R.id.listpersona);
            GetPerson();
            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,AregloPersoans);
            listView.setAdapter(adp);

            listView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                }
            });

        }catch (Exception ex){
            ex.toString();
        }
    }

    private void GetPerson() {
        SQLiteDatabase db = conecxion.getReadableDatabase();
        Personas person= null;

        lisperson = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.selectablePerosnas,null);
        while (cursor.moveToNext()){
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombre(cursor.getString(1));
            person.setApellido(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            lisperson.add(person);
        }

        cursor.close();
        fillist();
    }

    private void fillist() {
        AregloPersoans = new ArrayList<String>();
        for (int i=0 ; i< lisperson.size(); i++){
            AregloPersoans.add(lisperson.get(i).getId()+"-"+lisperson.get(i).getNombre()+"-"+lisperson.get(i).getApellido());
        }

    }


}