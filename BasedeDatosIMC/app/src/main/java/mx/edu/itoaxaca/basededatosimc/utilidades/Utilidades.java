package mx.edu.itoaxaca.basededatosimc.utilidades;

public class Utilidades {
    //Constantes campos tabla USUARIO
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID      = "id";
    public static final String CAMPO_NOMBRE  = "nombre";
    public static final String CAMPO_CINTURA = "cintura";
    public static final String CAMPO_CADERA  = "cadera";

    public static final String CREAR_TABLA_USUARIO =
            "CREATE TABLE "+TABLA_USUARIO+" ("+
                    CAMPO_ID + " INTEGER PRIMARY KEY, "+
                    CAMPO_NOMBRE + " TEXT, "+
                    CAMPO_CINTURA + " REAL, "+
                    CAMPO_CADERA + " REAL)"
            ;

}
