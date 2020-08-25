package mx.edu.itoaxaca.basededatosimc;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import mx.edu.itoaxaca.basededatosimc.entidades.Usuario;
import mx.edu.itoaxaca.basededatosimc.utilidades.Utilidades;

public class ListarPersonas extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String>  listaInformacion;
    ArrayList<Usuario> listaUsuario;
    ConexionSQLite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personas);

        conn = new ConexionSQLite(getApplicationContext(), "bd_usuarios",null, 1);

        listViewPersonas = (ListView) findViewById(R.id.listaPersonas);

        consultarLista();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);
    }

    private void consultarLista() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;
        listaUsuario = new ArrayList<Usuario>();
        //SELECT * FROM usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setCintura(cursor.getDouble(2));
            usuario.setCadera(cursor.getDouble(3));

            listaUsuario.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for(int i = 0 ; i < listaUsuario.size() ; i++){
            listaInformacion.add(listaUsuario.get(i).getId()+" - "+
                                 listaUsuario.get(i).getNombre()+" - "+
                                 listaUsuario.get(i).getCintura()+" - "+
                                 listaUsuario.get(i).getCadera()
            );

        }
    }
}
