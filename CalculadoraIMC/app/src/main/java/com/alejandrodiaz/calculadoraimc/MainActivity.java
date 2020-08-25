package com.alejandrodiaz.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final String NOMBRE = "X";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void icc (View v){
        EditText vName = (EditText) findViewById(R.id.name);
        Intent intencion = new Intent (this, ActivityICC.class);
        intencion.putExtra(NOMBRE,vName.getText().toString());
        startActivity(intencion);
    }

    public void imc (View v){
        EditText vName = (EditText) findViewById(R.id.name);
        Intent intencion = new Intent (this, ActivityIMC.class);
        intencion.putExtra(NOMBRE,vName.getText().toString());
        startActivity(intencion);
    }
}
