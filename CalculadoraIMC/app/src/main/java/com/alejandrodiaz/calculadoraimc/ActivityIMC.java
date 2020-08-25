package com.alejandrodiaz.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityIMC extends AppCompatActivity {
    static final String PESO     = "X";
    static final String ESTATURA = "Y";
    static final String SEXO     = "Z";
    static final String NOMBRE   = "W";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);
    }

    public void calculoIMC(View v){
        Toast estadoVal = Toast.makeText(getApplicationContext(), "Calculando...", Toast.LENGTH_LONG);
        estadoVal.show();
        EditText vPeso           = (EditText) findViewById(R.id.peso);
        EditText vEstatura       = (EditText) findViewById(R.id.estatura);
        RadioButton vBotonMujer  = (RadioButton) findViewById(R.id.mujer);
        RadioButton vBotonHombre = (RadioButton) findViewById(R.id.hombre);
        String vSexo  = vBotonMujer.isChecked()? "M" : "H";
        String nombre = getIntent().getStringExtra(MainActivity.NOMBRE);
        Intent activityNext = new Intent(this, ActivityResultados2.class);
            activityNext.putExtra(PESO, vPeso.getText().toString());
            activityNext.putExtra(ESTATURA, vEstatura.getText().toString());
            activityNext.putExtra(SEXO, vSexo);
            activityNext.putExtra(NOMBRE, nombre);
        startActivity(activityNext);
    }
}
