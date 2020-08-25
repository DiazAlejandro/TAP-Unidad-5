package mx.edu.itoaxaca.manejobdejamplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
// TODO Auto-generated constructor stub

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        db.execSQL("CREATE TABLE alumnos(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
    }
}
