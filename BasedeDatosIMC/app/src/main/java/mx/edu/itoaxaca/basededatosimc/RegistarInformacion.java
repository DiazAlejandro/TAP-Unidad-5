package mx.edu.itoaxaca.basededatosimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.itoaxaca.basededatosimc.utilidades.Utilidades;

public class RegistarInformacion extends AppCompatActivity {
    private EditText campoNombre;
    private EditText campoCintura;
    private EditText campoCadera;
    private EditText campoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_informacion);
        campoId      = (EditText) findViewById(R.id.id);
        campoNombre  = (EditText) findViewById(R.id.nombre);
        campoCintura = (EditText) findViewById(R.id.cintura);
        campoCadera  = (EditText) findViewById(R.id.cadera);
    }

    public void registro(View v){
        registrarUsuario();
    }

    private void registrarUsuario() {
        ConexionSQLite conn = new ConexionSQLite(this, "bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

            values.put(Utilidades.CAMPO_ID,      campoId.getText().toString());
            values.put(Utilidades.CAMPO_NOMBRE,  campoNombre.getText().toString());
            values.put(Utilidades.CAMPO_CINTURA, campoCintura.getText().toString());
            values.put(Utilidades.CAMPO_CADERA,  campoCadera.getText().toString());

            Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
            if (idResultante == -1)
                Toast.makeText(getApplicationContext(), "ID DUPLICADO \nRegisto no Realizado", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(getApplicationContext(), "ID REGISTRO" + idResultante, Toast.LENGTH_SHORT).show();
                db.close();
                limpiar();
            }

    }
    private void limpiar() {
        campoId.setText("");
        campoNombre.setText("");
        campoCadera.setText("");
        campoCintura.setText("");
    }

    public void irInicio(View v){
        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);
        finish();
    }
}
