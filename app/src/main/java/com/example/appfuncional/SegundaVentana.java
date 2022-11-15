package com.example.appfuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SegundaVentana extends AppCompatActivity {
    EditText edt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_ventana);

        edt3 = findViewById(R.id.ed3);


        //Muestra los parametros previamnete requiridos como el nombre y la contraseña
        Bundle recieved = getIntent().getExtras();
        edt3.setText("User: "+recieved.getString("user"));
    }

    protected void onStart() {
        super.onStart();
    }
    protected void onStop() {
        super.onStop();
    }


    public  void goToInicio(View h){
        Intent go = new Intent(this, MainActivity1.class);
        go.addFlags(go.FLAG_ACTIVITY_CLEAR_TASK | go.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(go);
    }
    public  void goToBD(View h){
        Intent go = new Intent(this, BaseDeDatos.class);
        go.addFlags(go.FLAG_ACTIVITY_CLEAR_TASK | go.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(go);
    }
}