package mx.edu.itoaxaca.manejobdejamplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    Conexion c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=new Conexion(this,"BDAlumno",null,1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sql, menu);
        return true;
    }
    public void insertarDB(View v)
    {
        SQLiteDatabase op= c.getWritableDatabase();
        op.execSQL("INSERT INTO alumnos(nombre) VALUES('Rogelio')");
        op.close();
        Toast.makeText(this,"guardado", 1).show();
    }
    public void devolverDB(View v)
    {
        SQLiteDatabase op= c.getReadableDatabase();
        String resultados="";
        Cursor cursor=
                op.rawQuery("SELECT * FROM alumnos",null);
        if(cursor.moveToFirst()){
            do{
                resultados += cursor.getString(0)+","+cursor.getString(1)+"-";
                Toast.makeText(this,resultados,1).show();
            }while(cursor.moveToNext());
            cursor.close();
        }


    }


}
