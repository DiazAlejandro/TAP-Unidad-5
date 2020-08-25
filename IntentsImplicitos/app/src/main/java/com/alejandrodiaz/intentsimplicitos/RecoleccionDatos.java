package com.alejandrodiaz.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**Clase que se encarga de reolectar los datos necesarios*/
public class RecoleccionDatos extends AppCompatActivity {
    static final String NOMBRE   = "U";
    static final String PESO     = "V";
    static final String ESTATURA = "W";
    static final String CADERA   = "X";
    static final String CINTURA  = "Y";
    static final String SEXO     = "Z";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoleccion_datos);
    }

    //Método que procesa los datos, según lo ingresado
    public void procesarDatos(View v){
        Toast estadoVal = Toast.makeText(getApplicationContext(), "Procesando...", Toast.LENGTH_LONG);
        estadoVal.show();

        EditText vNombre         = (EditText) findViewById(R.id.nombre);
        EditText vPeso           = (EditText) findViewById(R.id.peso);
        EditText vEstatura       = (EditText) findViewById(R.id.estatura);
        EditText vCadera         = (EditText) findViewById(R.id.cadera);
        EditText vCintura        = (EditText) findViewById(R.id.cintura);
        RadioButton vBotonMujer  = (RadioButton) findViewById(R.id.mujer);
        RadioButton vBotonHombre = (RadioButton) findViewById(R.id.hombre);
        String vSexo  = vBotonMujer.isChecked()? "M" : "H";

        Intent activityNext = new Intent(this, MainActivity.class);
            activityNext.putExtra(NOMBRE,   vNombre.getText().toString());
            activityNext.putExtra(PESO,     vPeso.getText().toString());
            activityNext.putExtra(ESTATURA, vEstatura.getText().toString());
            activityNext.putExtra(CADERA,   vCadera.getText().toString());
            activityNext.putExtra(CINTURA,  vCintura.getText().toString());
            activityNext.putExtra(SEXO,     vSexo);
        startActivity(activityNext);
    }
}
