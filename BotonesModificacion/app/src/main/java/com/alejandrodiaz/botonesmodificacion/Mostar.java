package com.alejandrodiaz.botonesmodificacion;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;

public class Mostar extends AppCompatActivity {
    //Declaracion de la caja de texto
    private TextView vNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostar);
        //Asocia el caja de texto con el de la vista
        vNumber = (TextView) findViewById(R.id.number);
        mostrarNumero();
    }
    /**Método para regresar a la actividad principal*/
    public void regresar(View v){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
        finish();
    }

    /**Método para mostrar el numero en el cuadro de texto*/
    public void mostrarNumero(){
        vNumber.setText(getIntent().getStringExtra(MainActivity.NUMERO));
    }
}
