package com.alejandrodiaz.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**Clase principal que muestra en una lista las opciones a ejecutar.*/
public class MainActivity extends ListActivity {
    private String [] opciones = {"Telefono A Marcar","Lectura de Datos","Calculo del IMC","Calculo del ICC"};
    static final String NOMBRE   = "U";
    static final String PESO     = "V";
    static final String ESTATURA = "W";
    static final String CADERA   = "X";
    static final String CINTURA  = "Y";
    static final String SEXO     = "Z";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Adaptador que se encarga de mostrar en una lista simple, las opciones que definimos en el arreglo
        ArrayAdapter<String> adaptadorLista = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,opciones);
        this.setListAdapter(adaptadorLista);
        this.getListView().setOnItemClickListener(
                //Clase anonima que se ejecuta cuando el usuario seleciona una opcion mostrada
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                        //segun la opcion seleccionada, se ejecuta el método correspondiente.
                        switch (i){
                            case 0: realizarLlamada();
                                break;
                            case 1: ejecutarRecoleccion();
                                break;
                            case 2: ejecutarIMC();
                                break;
                            case 3: ejecutarICC();
                                break;
                            default:
                        }
                    }
                }
        );
    }
    //Variables que almacenarán los datos que guardamos de la vista RecoleccionDatos
    String nombre, peso, estatura, cadera, cintura, sexo;

    //Método para ejecutar la actividad Recoleccion de datos
    public void ejecutarRecoleccion(){
        Intent intencion = new Intent (this, RecoleccionDatos.class);
        startActivity(intencion);
    }

    //Método para ejecutar la actividad IMC
    public void ejecutarIMC(){
        nombre   = getIntent().getStringExtra(RecoleccionDatos.NOMBRE);
        peso     = getIntent().getStringExtra(RecoleccionDatos.PESO);
        estatura = getIntent().getStringExtra(RecoleccionDatos.ESTATURA);
        sexo     = getIntent().getStringExtra(RecoleccionDatos.SEXO);

        Intent intencion = new Intent (this, IMC.class);
            intencion.putExtra(NOMBRE, nombre);
            intencion.putExtra(PESO, peso);
            intencion.putExtra(ESTATURA, estatura);
            intencion.putExtra(SEXO, sexo);
        startActivity(intencion);
    }

    //Método para ejecutar la actividad ICC
    public void ejecutarICC(){
        nombre   = getIntent().getStringExtra(RecoleccionDatos.NOMBRE);
        cadera   = getIntent().getStringExtra(RecoleccionDatos.CADERA);
        cintura  = getIntent().getStringExtra(RecoleccionDatos.CINTURA);
        sexo     = getIntent().getStringExtra(RecoleccionDatos.SEXO);

        Intent intencion = new Intent (this, ICC.class);
        intencion.putExtra(NOMBRE, nombre);
        intencion.putExtra(CADERA, cadera);
        intencion.putExtra(CINTURA, cintura);
        intencion.putExtra(SEXO, sexo);
        startActivity(intencion);
    }

    //Método que ejecuta la vista para ingresar la llamada
    public void realizarLlamada(){
        Intent intencion = new Intent (this, Llamada.class);
        startActivity(intencion);
    }
}
