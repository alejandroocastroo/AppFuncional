package com.example.appfuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appfuncional.db.DbHelper;

public class BaseDeDatos extends AppCompatActivity {

    Button btnCrearBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);

        btnCrearBD = findViewById(R.id.btnCrearBD);

        btnCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(BaseDeDatos.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(BaseDeDatos.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BaseDeDatos.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}