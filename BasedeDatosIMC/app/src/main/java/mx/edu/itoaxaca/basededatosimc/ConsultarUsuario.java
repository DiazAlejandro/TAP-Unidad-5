package mx.edu.itoaxaca.basededatosimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.itoaxaca.basededatosimc.utilidades.Utilidades;

public class ConsultarUsuario extends AppCompatActivity {

    static final String CADERA  = "X";
    static final String CINTURA = "Y";
    static final String SEXO    = "Z";
    static final String NOMBRE  = "W";

    private EditText campoID;
    private TextView campoNombre;
    private TextView campoCintura;
    private TextView campoCadera;

    ConexionSQLite conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        campoID      = (EditText) findViewById(R.id.idConsulta);
        campoNombre  = (TextView) findViewById(R.id.nombreConsulta);
        campoCintura = (EditText) findViewById(R.id.cinturaConsulta);
        campoCadera  = (TextView) findViewById(R.id.caderaConsulta);

        conn = new ConexionSQLite(getApplicationContext(),"bd_usuarios",null, 1);
    }



    public void consultar(View v){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campoID.getText().toString()};
        String[] campos     = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_CINTURA, Utilidades.CAMPO_CADERA};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();

            campoNombre.setText(cursor.getString(0));
            campoCintura.setText(cursor.getString(1));
            campoCadera.setText(cursor.getString(2));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El ID no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    public void borrarRegistro(View v) {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoID.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Registro Eliminado",Toast.LENGTH_LONG).show();
        campoID.setText("");
        limpiar();
        db.close();
    }

    public void actualizarUsuario(View v) {
        SQLiteDatabase db    = conn.getWritableDatabase();
        String[] parametros  = {campoID.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_CINTURA,campoCintura.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID + "=?",parametros);
        Toast.makeText(getApplicationContext(),"Cintura Actualizada",Toast.LENGTH_LONG).show();
        db.close();
        limpiar();

    }

    public void calculoICC(View v){
        Toast estadoVal = Toast.makeText(getApplicationContext(), "Calculando...", Toast.LENGTH_LONG);
        estadoVal.show();
        TextView vCadera   = (TextView) findViewById(R.id.caderaConsulta);
        EditText vCintura  = (EditText) findViewById(R.id.cinturaConsulta);
        TextView vNombre   = (TextView) findViewById(R.id.nombreConsulta);
        RadioButton vBotonMujer  = (RadioButton) findViewById(R.id.mujer);
        RadioButton vBotonHombre = (RadioButton) findViewById(R.id.hombre);
        String vSexo  = vBotonMujer.isChecked()? "M" : "H";
        Intent activityNext = new Intent(this, ActivityResultados.class);
            activityNext.putExtra(CADERA, vCadera.getText().toString());
            activityNext.putExtra(CINTURA, vCintura.getText().toString());
            activityNext.putExtra(NOMBRE, vNombre.getText().toString());
            activityNext.putExtra(SEXO, vSexo);
        startActivity(activityNext);
    }

    private void limpiar() {
        campoID.setText("");
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
