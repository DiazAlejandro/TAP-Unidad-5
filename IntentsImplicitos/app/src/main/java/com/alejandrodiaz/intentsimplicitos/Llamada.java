package com.alejandrodiaz.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**Clase que se encarga de realizar la ejecución de la llamada*/
public class Llamada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada);
    }

    //Método que se activa dentro del botón realizar llamada
    public void llamada(View v){
        //Toast de estado para procesar la llamada
        Toast estadoVal = Toast.makeText(getApplicationContext(), "Procesando Llamada...", Toast.LENGTH_LONG);
        estadoVal.show();

        //Recupera el numero que hayamos introducido
        EditText vTelefono = (EditText) findViewById(R.id.telefono);
        String tel = vTelefono.getText().toString();

        //Ejecuta la llamada al telefono y le pasa como parametro a Uri.parse el telefono.
        Intent activityLlamada = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+tel));
        startActivity(activityLlamada);
    }
}
