package com.alejandrodiaz.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivityICC extends AppCompatActivity {
    static final String CADERA  = "X";
    static final String CINTURA = "Y";
    static final String SEXO    = "Z";
    static final String NOMBRE  = "W";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_c_c);
    }

    public void calculoICC(View v){
        Toast estadoVal = Toast.makeText(getApplicationContext(), "Calculando...", Toast.LENGTH_LONG);
        estadoVal.show();
        EditText vCadera         = (EditText) findViewById(R.id.cadera);
        EditText vCintura        = (EditText) findViewById(R.id.cintura);
        RadioButton vBotonMujer  = (RadioButton) findViewById(R.id.mujer);
        RadioButton vBotonHombre = (RadioButton) findViewById(R.id.hombre);
        String vSexo  = vBotonMujer.isChecked()? "M" : "H";
        String nombre = getIntent().getStringExtra(MainActivity.NOMBRE);
        Intent activityNext = new Intent(this, ActivityResultados.class);
            activityNext.putExtra(CADERA, vCadera.getText().toString());
            activityNext.putExtra(CINTURA, vCintura.getText().toString());
            activityNext.putExtra(SEXO, vSexo);
            activityNext.putExtra(NOMBRE, nombre);
        startActivity(activityNext);
    }
}
