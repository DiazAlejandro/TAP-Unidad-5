package mx.edu.itoaxaca.concurredplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Routes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
    }

    public void openMain(View v){
        Intent main = new Intent(this, MainActivity.class);
        finish();
        startActivity(main);
    }
}
