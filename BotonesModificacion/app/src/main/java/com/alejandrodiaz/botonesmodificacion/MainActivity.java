package com.alejandrodiaz.botonesmodificacion;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private      Button btn[][];  //Arreglo de botones
    private      TextView vText;  //Cada de texto
    private      String str = ""; //String que concatenará los numeros
    static final String NUMERO = "x"; //String que servirá para enviar los datos a la siguiente actividad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asocia los elementos del arreglo con los de la vista
        btn = new Button[4][3];
        btn[0][0] = (Button) findViewById(R.id.b1);
        btn[0][1] = (Button) findViewById(R.id.b2);
        btn[0][2] = (Button) findViewById(R.id.b3);
        btn[1][0] = (Button) findViewById(R.id.b4);
        btn[1][1] = (Button) findViewById(R.id.b5);
        btn[1][2] = (Button) findViewById(R.id.b6);
        btn[2][0] = (Button) findViewById(R.id.b7);
        btn[2][1] = (Button) findViewById(R.id.b8);
        btn[2][2] = (Button) findViewById(R.id.b9);
        btn[3][0] = (Button) findViewById(R.id.b0);
        btn[3][1] = (Button) findViewById(R.id.delete);
        btn[3][2] = (Button) findViewById(R.id.bx);

        vText = (TextView) findViewById(R.id.text);
        accionBoton();
    }

    //Método que se encarga de mostrar el nombre del boton según el pulsado
    public void accionBoton(){
        //Dos ciclos para recorrer la matriz
        for (int fila = 0 ; fila < btn.length ; fila++){
            for (int columna = 0 ; columna < btn[fila].length ; columna++){
                btn[fila][columna].setOnClickListener( //Añade un listener al boton seleccionado
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) { //Agrega el método onClick según el botón que geere el evento
                                Button bt = (Button) v; //Recupera el boton pulsado en otra variable.
                                //Condiciones para decidir si va a borrar un digito
                                if(bt.getText().toString().equals("-")){
                                    Toast toast1 =Toast.makeText(getApplicationContext(),
                                                    "Borrar Un Digito", Toast.LENGTH_SHORT);
                                    toast1.show();
                                    str = str.substring(0, str.length() - 1); //Recorta un digito al string
                                    vText.setText(str);
                                }else //Condición para borrar todo el string
                                if(bt.getText().toString().equals("x")) {
                                    Toast toast2 = Toast.makeText(getApplicationContext(),
                                            "Borrar todo", Toast.LENGTH_SHORT);
                                    toast2.show();
                                    vText.setText("");
                                    str = "";
                                }else{
                                str += bt.getText().toString(); //Concatena los caracteres
                                vText.setText(str);
                                }
                            }
                        }
                );
            }
        }
    }

    /**Método par mostrar la siguiente vista*/
    public void mostrar(View v){
        Intent next = new Intent(MainActivity.this, Mostar.class);
            next.putExtra(NUMERO,str);
        startActivity(next);
        finish();
    }

    public void salir (View v){
        System.exit(0);
    }
}
