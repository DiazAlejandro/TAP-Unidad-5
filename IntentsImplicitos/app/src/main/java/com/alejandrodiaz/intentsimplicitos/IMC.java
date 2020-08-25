package com.alejandrodiaz.intentsimplicitos;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IMC extends AppCompatActivity {
    private TextView vResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);
        vResults = (TextView) findViewById(R.id.results);
        calculoIMC();
    }

    public void calculoIMC() {

        //vName.setText(getIntent().getStringExtra(ActivityICC.NOMBRE));
        try {
            double peso     = Double.parseDouble(getIntent().getStringExtra(MainActivity.PESO));
            double estatura = Double.parseDouble(getIntent().getStringExtra(MainActivity.ESTATURA));
            String sexo     = getIntent().getStringExtra(MainActivity.SEXO);
            double imc      = peso / (Math.pow(estatura,2.0));
            double pesoIdeal1 = (Math.pow(estatura,2.0)) * 18.50;
            String pesoASubir = String.format("%.2f",pesoIdeal1 - peso);
            double pesoIdeal2 = (Math.pow(estatura,2.0)) * 24.99;
            String pesoABajar = String.format("%.2f",peso - pesoIdeal2);

            String str = "\tNombre: "+getIntent().getStringExtra(MainActivity.NOMBRE)+"\n\n"+
                    "\tSexo: "+(sexo.equals("M") ? "FEMENINO" : "MASCULINO")+"\n";
            if (imc <= 18.49) { //Condición para determinar si es Bajo Peso
                if (imc < 16.00)
                    str += ("\tClasificación: Bajo Peso\n\tDelgadez severa"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                else if (imc >= 16.00 && imc <= 16.99)
                    str += ("\tClasificación: Bajo Peso\n\tDelgadez moderada"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                else if (imc >= 17.00 && imc <= 18.49)
                    str += ("\tClasificación: Bajo Peso\n\tDelgadez aceptable"+
                            "\n\tNecesita subir: "+ pesoASubir +" Kg.");
                //Fin de las condiciones para las personas con Bajo Peso
            }else
            if (imc >= 18.50 && imc <= 24.99)  //Condicion para las personas que tengan un peso normal
                str += ("\tClasificación: Peso Normal");
            else
            if (imc >= 25.00 && imc <=29.99) { //Condicion para las personas con sobrepeso
                str += ("\tClasificación: SobrePeso\n\tPre-obeso (RIESGO)" +
                        "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                //Fin de la condicion para las personas con sobrepeso
            }else
            if (imc >= 30){ //Condicion para las personas que tengan obesidad
                if (imc >= 30.00 && imc <= 34.99)
                    str += ("\tClasificación: Obeso\n\tObesidad Tipo I (RIESGO - Moderado)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                else if (imc >= 35.00 && imc <= 39.99)
                    str += ("\tClasificación: Obeso\n\tObesidad Tipo II (RIESGO - Severo)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                else if (imc >= 40.00)
                    str += ("\tClasificación: Obeso\n\tObesidad Tipo III (RIESGO - Muy Severo)"+
                            "\n\tNecesita Bajar: " + pesoABajar + " Kg.");
                //Fin de las condiciones para las personas con Obesidad


            }
            vResults.setText(str);
        }catch(Exception e){

        }
    }
}
