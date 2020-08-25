package mx.edu.itoaxaca.basededatosimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import mx.edu.itoaxaca.basededatosimc.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instancia de la clase Conexion
        ConexionSQLite conn = new ConexionSQLite(this, "db_usuarios",null, 1);
    }

    public void abrirRegistro(View v){
        Intent openR = new Intent(this, RegistarInformacion.class);
        startActivity(openR);
    }

    public void abrirConsulta(View v){
        Intent openC = new Intent(this, ConsultarUsuario.class);
        startActivity(openC);
    }

    public void abrirLista(View v){
        Intent openR = new Intent(this, ListarPersonas.class);
        startActivity(openR);
    }

    public void cerrar(View v){
        System.exit(0);

    }
}
