package com.alejandrodiaz.botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaracion de la matriz de botones y la caja de texto
    Button btn[][];
    TextView vText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Crea las referencias y asocia de acuerdo a cada boton
        btn = new Button[4][4];
        btn[0][0] = (Button) findViewById(R.id.b1);
        btn[0][1] = (Button) findViewById(R.id.b2);
        btn[0][2] = (Button) findViewById(R.id.b3);
        btn[0][3] = (Button) findViewById(R.id.b4);
        btn[1][0] = (Button) findViewById(R.id.b5);
        btn[1][1] = (Button) findViewById(R.id.b6);
        btn[1][2] = (Button) findViewById(R.id.b7);
        btn[1][3] = (Button) findViewById(R.id.b8);
        btn[2][0] = (Button) findViewById(R.id.b9);
        btn[2][1] = (Button) findViewById(R.id.b10);
        btn[2][2] = (Button) findViewById(R.id.b11);
        btn[2][3] = (Button) findViewById(R.id.b12);
        btn[3][0] = (Button) findViewById(R.id.b13);
        btn[3][1] = (Button) findViewById(R.id.b14);
        btn[3][2] = (Button) findViewById(R.id.b15);
        btn[3][3] = (Button) findViewById(R.id.b16);

        vText = (TextView) findViewById(R.id.text);
        accionBoton();
    }
    //Método que se encarga de mostrar el nombre del boton según el pulsado
    public void accionBoton(){
        //Dos ciclos para recorrer la matriz
        for (int fila = 0 ; fila < btn.length ; fila++){
            for (int columna = 0 ; columna < btn.length ; columna++){
                btn[fila][columna].setOnClickListener( //Añade un listener al boton seleccionado
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) { //Agrega el método onClick según el botón que geere el evento
                                Button bt = (Button) v;
                                vText.setText(bt.getText());
                            }
                        }
                );
            }
        }
    }
}
