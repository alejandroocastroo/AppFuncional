package com.example.appfuncional;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    EditText ed1, ed2; // instancia de la clase EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.edName); // enlazamiento
        ed2 = findViewById(R.id.edPasswd); // enlazamiento

    }

    @Override
    protected void onStart() {super.onStart();}
    @Override
    protected void onStop() {super.onStop();}


    //metodo para ingresar a la segunda ventana, validando que los campos no esten vacios
    public  void goToSegundaVentana(View h){
        Intent go = new Intent(this, SegundaVentana.class);
        go.addFlags(go.FLAG_ACTIVITY_CLEAR_TASK | go.FLAG_ACTIVITY_CLEAR_TOP);
        if(ed1.getText().toString().matches("") || ed2.getText().toString().matches("")){
            //Toast.makeText(this, "Please pick both fields", Toast.LENGTH_LONG).show();
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Advertencia, debe diligenciar ambos campos")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // START THE GAME!
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            builder.create().show();
        }else {
            Bundle data = new Bundle();
            data.putString("user",ed1.getText().toString());
            data.putString("passw",ed2.getText().toString());
            go.putExtras(data);
            startActivity(go);
        }
    }

}
