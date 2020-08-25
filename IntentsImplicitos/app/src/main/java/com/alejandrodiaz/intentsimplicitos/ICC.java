package com.alejandrodiaz.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ICC extends AppCompatActivity {
    static final String CADERA  = "X";
    static final String CINTURA = "Y";
    static final String SEXO    = "Z";
    static final String NOMBRE  = "W";
    private TextView vResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_c_c);
        vResults = (TextView) findViewById(R.id.results2);
        calculoICC();
    }

    public void calculoICC() {
        //vName.setText(getIntent().getStringExtra(ActivityICC.NOMBRE)); //Asigna el nombre
        try {
            //Convierte a doble los datos ingresados
            double cintura = Double.parseDouble(getIntent().getStringExtra(MainActivity.CINTURA));
            double cadera = Double.parseDouble(getIntent().getStringExtra(MainActivity.CADERA));
            String sexo = getIntent().getStringExtra(MainActivity.SEXO);
            //Operaciones
            double valorI = cintura / cadera;
            String riesgo = "";
            //Condiciones para determinar su estado de salud
            if (sexo.equals("M")) {
                if (valorI < 0.81) riesgo = "BAJO";
                else if (valorI < 0.86) riesgo = "MODERADO";
                else riesgo = "ALTO";
            } else {
                if (valorI < 0.96) riesgo = "BAJO";
                else if (valorI < 1) riesgo = "MODERADO";
                else riesgo = "ALTO";
            }

            //Asigna los resultados
            vResults.setText("\tNombre: "+getIntent().getStringExtra(MainActivity.NOMBRE)
                    +"\n\n\tPara una persona del sexo: " +
                    (sexo.equals("M") ? "FEMENINO" : "MASCULINO") +
                    "\n\tSu ICC = " + String.format("%.2f", valorI) +
                    "\n\tRepresenta un riesgo: " + riesgo + "\n\tpara su salud...");
        } catch (Exception e) {
            Toast estadoVal = Toast.makeText(getApplicationContext(), "ERROR"+e, Toast.LENGTH_LONG);
            estadoVal.show();
        }
    }
}
