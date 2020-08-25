package com.example.mainactivitycica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    //Declaracion de las variables para obtener los valores de los elementos activity_main
    private EditText lecAnt;
    private EditText lecAct;
    private TextView consum;
    private TextView imprt;

    //Declaracion de variables para hacer los cálculos
    private final double valImpuesto      = 10;
    private final double valMantenimiento = 15;
    private final double precioMt3        = 7;
    private double vImporte;
    private double vConsumo;
    private double impuesto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establecer las referencias para obtener los valores
        lecAct = (EditText) findViewById(R.id.lecturaAct);
        lecAnt = (EditText) findViewById(R.id.lecturaAnt);
        consum = (TextView) findViewById(R.id.consumo);
        imprt  = (TextView) findViewById(R.id.importe);
    }

    /**
     * Operaciones para calcular el importe a pagar
     * */
    public void calculo (View w){
        Toast incompeto = null;
        Toast menor     = null;
        int consumoMt3;
        if (lecAct.getText().toString().isEmpty() || lecAnt.getText().toString().isEmpty()) {
            incompeto = Toast.makeText(getApplicationContext(), "Llene todos los campos", Toast.LENGTH_LONG);
            incompeto.show();
        }else if (Integer.parseInt(lecAct.getText().toString()) < Integer.parseInt(lecAnt.getText().toString())){
            menor = Toast.makeText(getApplicationContext(),
                    "La lectura actual tiene que ser MAYOR que la anterior", Toast.LENGTH_LONG);
            menor.show();
        }else{
             consumoMt3 = Integer.parseInt(lecAct.getText().toString()) -
                    Integer.parseInt(lecAnt.getText().toString());
            vConsumo = consumoMt3 * precioMt3;
            impuesto = vConsumo * ((valImpuesto) / 100);
            vImporte = vConsumo + impuesto + valMantenimiento;
            consum.setText("" + consumoMt3);
            imprt.setText("" + vImporte);
        }
    }

    /**
     * Ver detalle en un toast de estado la informacion del importe
     * */
    public void detalle(View w){
        String detalle =   "Consumo:        $ " + vConsumo +
                         "\nImpuesto:       $ " + impuesto +
                         "\nMantenimiento:  $ " + valMantenimiento +
                         "\nImporte Total:  $ " + vImporte;
        Toast mensajeDetalle = Toast.makeText(getApplicationContext(),detalle,Toast.LENGTH_LONG);
        mensajeDetalle.show();
    }

    /**
     * Limpiar los datos ingresados
     * */
    public void limpiar (View w){
        lecAnt.setText("");
        lecAct.setText("");
        consum.setText("");
        imprt.setText("---");
    }
}
