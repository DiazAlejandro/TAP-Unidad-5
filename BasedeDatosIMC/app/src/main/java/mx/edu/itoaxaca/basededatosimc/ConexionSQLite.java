package mx.edu.itoaxaca.basededatosimc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import mx.edu.itoaxaca.basededatosimc.utilidades.Utilidades;

public class ConexionSQLite extends SQLiteOpenHelper {
    //Script para crear la base de datos


    //Constructor que crea la Base de datos
    public ConexionSQLite(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Generar las tablas correspondientes
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }
    //Verifica si ya existe la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
