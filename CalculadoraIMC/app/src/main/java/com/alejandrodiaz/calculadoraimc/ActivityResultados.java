package com.alejandrodiaz.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityResultados extends AppCompatActivity {
    static final String NOMBRE = "X";
    private TextView vName;
    private TextView vResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        vName    = (TextView) findViewById(R.id.nameR);
        vResults = (TextView) findViewById(R.id.results);
        calculoICC();
    }

    public void calculoICC() {
        vName.setText(getIntent().getStringExtra(ActivityICC.NOMBRE));
        try {
            double cintura = Double.parseDouble(getIntent().getStringExtra(ActivityICC.CINTURA));
            double cadera = Double.parseDouble(getIntent().getStringExtra(ActivityICC.CADERA));
            String sexo = getIntent().getStringExtra(ActivityICC.SEXO);
            double valorI = cintura / cadera;
            String riesgo = "";

            if (sexo.equals("M")) {
                if (valorI < 0.81) riesgo = "BAJO";
                else if (valorI < 0.86) riesgo = "MODERADO";
                else riesgo = "ALTO";
            } else {
                if (valorI < 0.96) riesgo = "BAJO";
                else if (valorI < 1) riesgo = "MODERADO";
                else riesgo = "ALTO";
            }

            vResults.setText("Para una persona del sexo: " +
                    (sexo.equals("M") ? "FEMENINO" : "MASCULINO") +
                    "\nSu ICC = " + String.format("%.2f", valorI) +
                    "\nRepresenta un riesgo: " + riesgo + "\npara su salud...");
        } catch (Exception e) {
            Toast estadoVal = Toast.makeText(getApplicationContext(), "ERROR"+e, Toast.LENGTH_LONG);
            estadoVal.show();
        }
    }

    public void irInicio(View v){
            Intent inicio = new Intent(this, MainActivity.class);
            startActivity(inicio);
        }
    public void irIMC(View v){
        TextView vName = (TextView) findViewById(R.id.nameR);
        Intent imc = new Intent(this, ActivityIMC.class);
        imc.putExtra(NOMBRE,vName.getText().toString());
        startActivity(imc);
    }

}
