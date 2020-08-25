package com.alejandrodiaz.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    //Declaración de variables para acceder a los datos
    private EditText name;
    private EditText peso;
    private EditText estatura;
    private TextView resultado;
    private TextView clasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establece las referencias con el archivo .xml
        name          = (EditText) findViewById(R.id.name);
        peso          = (EditText) findViewById(R.id.peso);
        estatura      = (EditText) findViewById(R.id.estatura);
        resultado     = (TextView) findViewById(R.id.resultado);
        clasificacion = (TextView) findViewById(R.id.clasificacion);
    }

    //Variables para realizar los calulos del IMC
    private double imc = 0; //Almacena el calculo del IMC
    private double pes;     //Almacena el peso en kg
    private double est;     //Alamacena la estatura en metros
    /**Método para realizar el calculo del IMC*/
    public void calcular (View v){
        String nom = name.getText().toString();
               est = Double.parseDouble(estatura.getText().toString());
               pes = Double.parseDouble(peso.getText().toString());
               imc = pes / (Math.pow(est,2.0));
        resultado.setText("Nombre: "+nom+"\nIMC: "+String.format("%.2f",imc));
        clasificacion(); //Ejecuta el método clasificación();
    }

    @SuppressLint("SetTextI18n")
    /**Método para mostrar la clasificación a la que pertenece según el IMC*/
    public void clasificacion(){
        //Realiza el calculo del peso ideal, para las personas que sean Bajo Peso
        double pesoIdeal1 = (Math.pow(est,2.0)) * 18.50;
        //Pasa a un String el peso ideal para que únicamente muestre 2 decimales.
        String pesoASubir = String.format("%.2f",pesoIdeal1 - pes);
        //Realiza el calculo del peso ideal, para las personas que sean Sobre Pesp
        double pesoIdeal2 = (Math.pow(est,2.0)) * 24.99;
        //Pasa a un String el peso ideal para que únicamente muestre 2 decimales.
        String pesoABajar = String.format("%.2f",pes - pesoIdeal2);


        if (imc <= 18.49) { //Condición para determinar si es Bajo Peso
            if (imc < 16.00)
                clasificacion.setText("\tClasificación: Bajo Peso\n\t Delgadez severa"+
                        "\n\t Necesita subir: "+ pesoASubir +" Kg.");
            else if (imc >= 16.00 && imc <= 16.99)
                clasificacion.setText("\tClasificación: Bajo Peso\n\t Delgadez moderada"+
                        "\n\t Necesita subir: "+ pesoASubir +" Kg.");
            else if (imc >= 17.00 && imc <= 18.49)
                clasificacion.setText("\tClasificación: Bajo Peso\n\t Delgadez aceptable"+
                        "\n\t Necesita subir: "+ pesoASubir +" Kg.");
            //Fin de las condiciones para las personas con Bajo Peso
        }else
            if (imc >= 18.50 && imc <= 24.99)  //Condicion para las personas que tengan un peso normal
                clasificacion.setText("\tClasificación: Peso Normal");
            else
                if (imc >= 25.00 && imc <=29.99) { //Condicion para las personas con sobrepeso
                    clasificacion.setText("\tClasificación: SobrePeso\n\t Pre-obeso (RIESGO)" +
                            "\n\t Necesita Bajar: " + pesoABajar + " Kg.");
                    //Fin de la condicion para las personas con sobrepeso
                }else
                    if (imc >= 30){ //Condicion para las personas que tengan obesidad
                        if (imc >= 30.00 && imc <= 34.99)
                            clasificacion.setText("\tClasificación: Obeso\n\t Obesidad Tipo I (RIESGO - Moderado)"+
                                    "\n\t Necesita Bajar: " + pesoABajar + " Kg.");
                        else if (imc >= 35.00 && imc <= 39.99)
                            clasificacion.setText("\tClasificación: Obeso\n\t Obesidad Tipo II (RIESGO - Severo)"+
                                    "\n\t Necesita Bajar: " + pesoABajar + " Kg.");
                        else if (imc >= 40.00)
                            clasificacion.setText("\tClasificación: Obeso\n\t Obesidad Tipo III (RIESGO - Muy Severo)"+
                                    "\n\t Necesita Bajar: " + pesoABajar + " Kg.");
                        //Fin de las condiciones para las personas con Obesidad
                    }
    }

    public void limpiar (View v){
            clasificacion.setText("");
            name.setText("");
            estatura.setText("");
            peso.setText("");
            resultado.setText("");
    }
}
