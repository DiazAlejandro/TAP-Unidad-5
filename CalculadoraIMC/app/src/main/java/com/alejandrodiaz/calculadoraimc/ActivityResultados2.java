package com.alejandrodiaz.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResultados2 extends AppCompatActivity {
    static final String NOMBRE = "X";
    private TextView vName;
    private TextView vResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados2);
        vName    = (TextView) findViewById(R.id.nameR2);
        vResults = (TextView) findViewById(R.id.results2);
        calculoIMC();
    }

    public void calculoIMC() {
        vName.setText(getIntent().getStringExtra(ActivityICC.NOMBRE));
        try {
            double peso     = Double.parseDouble(getIntent().getStringExtra(ActivityIMC.PESO));
            double estatura = Double.parseDouble(getIntent().getStringExtra(ActivityIMC.ESTATURA));
            String sexo     = getIntent().getStringExtra(ActivityICC.SEXO);
            double imc      = peso / (Math.pow(estatura,2.0));
            //Realiza el calculo del peso ideal, para las personas que sean Bajo Peso
            double pesoIdeal1 = (Math.pow(estatura,2.0)) * 18.50;
            //Pasa a un String el peso ideal para que únicamente muestre 2 decimales.
            String pesoASubir = String.format("%.2f",pesoIdeal1 - peso);
            //Realiza el calculo del peso ideal, para las personas que sean Sobre Pesp
            double pesoIdeal2 = (Math.pow(estatura,2.0)) * 24.99;
            //Pasa a un String el peso ideal para que únicamente muestre 2 decimales.
            String pesoABajar = String.format("%.2f",peso - pesoIdeal2);


            if (imc <= 18.49) { //Condición para determinar si es Bajo Peso
                if (imc < 16.00)
                    vResults.setText("\tClasificación: Bajo Peso\n\tDelgadez severa"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                else if (imc >= 16.00 && imc <= 16.99)
                    vResults.setText("\tClasificación: Bajo Peso\n\tDelgadez moderada"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                else if (imc >= 17.00 && imc <= 18.49)
                    vResults.setText("\tClasificación: Bajo Peso\n\tDelgadez aceptable"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                //Fin de las condiciones para las personas con Bajo Peso
            }else
            if (imc >= 18.50 && imc <= 24.99)  //Condicion para las personas que tengan un peso normal
                vResults.setText("\tClasificación: Peso Normal");
            else
            if (imc >= 25.00 && imc <=29.99) { //Condicion para las personas con sobrepeso
                vResults.setText("\tClasificación: SobrePeso\n\tPre-obeso (RIESGO)" +
                        "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                //Fin de la condicion para las personas con sobrepeso
            }else
            if (imc >= 30){ //Condicion para las personas que tengan obesidad
                if (imc >= 30.00 && imc <= 34.99)
                    vResults.setText("\tClasificación: Obeso\n\tObesidad Tipo I (RIESGO - Moderado)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                else if (imc >= 35.00 && imc <= 39.99)
                    vResults.setText("\tClasificación: Obeso\n\tObesidad Tipo II (RIESGO - Severo)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                else if (imc >= 40.00)
                    vResults.setText("\tClasificación: Obeso\n\tObesidad Tipo III (RIESGO - Muy Severo)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                //Fin de las condiciones para las personas con Obesidad
            }
        }catch(Exception e){

        }
    }
    public void irInicio(View v){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
    }

    public void irICC(View v){
        TextView vName = (TextView) findViewById(R.id.nameR2);
        Intent icc = new Intent(this, ActivityICC.class);
        icc.putExtra(NOMBRE,vName.getText().toString());
        startActivity(icc);
    }
}
