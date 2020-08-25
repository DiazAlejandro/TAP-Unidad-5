package mx.edu.itoaxaca.SonidosTexto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variables
    private MediaPlayer reproductor;
    private MediaPlayer sujeto, accion, lugar;
    private TextView frase;
    //Sujeto
    private ImageButton ibmorro;
    private ImageButton ibpolar;
    private ImageButton ibgato;
    //Verbo
    private ImageButton ibcaminar;
    private ImageButton ibcomida;
    private ImageButton ibestudia;
    //Lugar
    private ImageButton ibbosque;
    private ImageButton ibcasa;
    private ImageButton ibcoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignacion de las referencias
        frase = (TextView) findViewById(R.id.tFrase);
        //Sujeto
        ibmorro = (ImageButton) findViewById(R.id.bMorro);
        ibpolar = (ImageButton) findViewById(R.id.bPolar);
        ibgato = (ImageButton) findViewById(R.id.bGato);
        //Verbo
        ibcaminar = (ImageButton) findViewById(R.id.bCamina);
        ibcomida = (ImageButton) findViewById(R.id.bComida);
        ibestudia = (ImageButton) findViewById(R.id.bEstudia);
        //Lugar
        ibbosque = (ImageButton) findViewById(R.id.bBosque);
        ibcasa = (ImageButton) findViewById(R.id.bCasa);
        ibcoche = (ImageButton) findViewById(R.id.bCoche);
    }

    private String str = "";

    public void fraseAudible(View v) {
        switch (v.getId()) {
            /**Casos del sujeto PRIMER renglón*/
            case R.id.bMorro:
                if (reproductor == null || !reproductor.isPlaying()) {
                    renglon1Desactivado("El niño ");
                    reproductor = MediaPlayer.create(this, R.raw.morro);
                    sujeto = reproductor;
                    reproductor.start();
                }
                break;

            case R.id.bPolar:
                if (reproductor == null || !reproductor.isPlaying()) {
                    renglon1Desactivado("El Oso Polar ");
                    reproductor = MediaPlayer.create(this, R.raw.polar);
                    sujeto = reproductor;
                    reproductor.start();
                }
                break;

            case R.id.bGato:
                if (reproductor == null || !reproductor.isPlaying()) {
                    renglon1Desactivado("El gato ");
                    reproductor = MediaPlayer.create(this, R.raw.gato);
                    sujeto = reproductor;
                    reproductor.start();
                }
                break;

            /**Casos de la accion SEGUNDO renglón*/
            case R.id.bCamina:
                if (validarRenglon1()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon2Desactivado("camina ");
                        reproductor = MediaPlayer.create(this, R.raw.caminar);
                        accion = reproductor;
                        reproductor.start();
                    }
                }
                break;

            case R.id.bComida:
                if (validarRenglon1()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon2Desactivado("come ");
                        reproductor = MediaPlayer.create(this, R.raw.comida);
                        accion = reproductor;
                        reproductor.start();
                    }
                }
                break;

            case R.id.bEstudia:
                if (validarRenglon1()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon2Desactivado("estudia ");
                        reproductor = MediaPlayer.create(this, R.raw.estudia);
                        accion = reproductor;
                        reproductor.start();
                    }
                }
                break;

            /**Casos del lugar TERCER renglón*/
            case R.id.bBosque:
                if (validarRenglon2()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon3Desactivado("en el bosque.");
                        reproductor = MediaPlayer.create(this, R.raw.bosque);
                        lugar = reproductor;
                        reproductor.start();
                    }
                }
                break;
            case R.id.bCasa:
                if (validarRenglon2()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon3Desactivado("en la casa.");
                        reproductor = MediaPlayer.create(this, R.raw.casa);
                        lugar = reproductor;
                        reproductor.start();
                    }
                }
                break;

            case R.id.bCoche:
                if (validarRenglon2()) {
                } else {
                    if (reproductor == null || !reproductor.isPlaying()) {
                        renglon3Desactivado("en el coche.");
                        reproductor = MediaPlayer.create(this, R.raw.coche);
                        lugar = reproductor;
                        reproductor.start();
                    }
                }
                break;
        }
    }

    /**
     * Método que desactiva los botones del renglon 1
     *
     * @param sujeto Recibe el sujeto seleccionado del renglon uno.
     */
    public void renglon1Desactivado(String sujeto) {
        str += sujeto;
        frase.setText(str);
        ibmorro.setEnabled(false);
        ibpolar.setEnabled(false);
        ibgato.setEnabled(false);

    }

    /**
     * Método que desactiva los botones del renglon 2
     *
     * @param accion Recibe la accion seleccionada del renglon dos
     */
    public void renglon2Desactivado(String accion) {
        str += accion;
        frase.setText(str);
        ibcaminar.setEnabled(false);
        ibcomida.setEnabled(false);
        ibestudia.setEnabled(false);
    }

    /**
     * Método que desactiva los botones del renglon 3
     *
     * @param lugar Recibe el lugar de la imagen seleccionada del renglon tres
     */
    public void renglon3Desactivado(String lugar) {
        str += lugar;
        frase.setText(str);
        ibbosque.setEnabled(false);
        ibcasa.setEnabled(false);
        ibcoche.setEnabled(false);
    }

    /**
     * Método para validar que el renglón 1 haya seleccionado una imagen
     *
     * @return false si ya seleccionó una imagen.
     */
    public boolean validarRenglon1() {
        if (ibmorro.isEnabled() || ibpolar.isEnabled() || ibgato.isEnabled()) {
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Seleccione un elemento del PRIMER renglón", Toast.LENGTH_SHORT);
            toast1.show();
            return true;
        }
        return false;
    }

    /**
     * Método para validar que el renglón 2 haya seleccionado una imagen
     *
     * @return false si ya seleccionó una imagen.
     */
    public boolean validarRenglon2() {
        if (ibcaminar.isEnabled() || ibcomida.isEnabled() || ibestudia.isEnabled()) {
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Seleccione un elemento del SEGUNDO renglón", Toast.LENGTH_SHORT);
            toast1.show();
            return true;
        }
        return false;
    }

    /**
     * Método para restaurar todos los botones
     */
    public void restaurar(View v) {
        frase.setText("--- Frase ---");
        str = "";
        //Audios
        sujeto = null;
        accion = null;
        lugar = null;
        //Sujeto
        ibmorro.setEnabled(true);
        ibpolar.setEnabled(true);
        ibgato.setEnabled(true);
        //Verbo
        ibcaminar.setEnabled(true);
        ibcomida.setEnabled(true);
        ibestudia.setEnabled(true);
        //Lugar
        ibbosque.setEnabled(true);
        ibcasa.setEnabled(true);
        ibcoche.setEnabled(true);
    }

    /**
     * Método para salir de la aplicacion
     */
    public void salir(View v) {
        System.exit(0);
    }

    /**
     * Método para repetir el audio completo
     */
    public void reproducir(View v) {
        if(sujeto == null){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "No hay Audios em cola", Toast.LENGTH_SHORT);
            toast1.show();
            return;
        }
        sujeto.start();
        while(sujeto.isPlaying()){

        }accion.start();
        while(accion.isPlaying()){

        }lugar.start();
    }
}
