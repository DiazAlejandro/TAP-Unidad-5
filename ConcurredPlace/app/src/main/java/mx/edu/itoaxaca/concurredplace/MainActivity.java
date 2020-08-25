package mx.edu.itoaxaca.concurredplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRecommedations(View v){
        Intent openRecc = new Intent(this, Recommendations.class);
        startActivity(openRecc);
    }

    public void openInformation(View v){
        Intent openInfo = new Intent(this, Information.class);
        startActivity(openInfo);
    }

    public void openRoutes(View v){
        Intent openRoutes = new Intent(this, Routes.class);
        startActivity(openRoutes);
    }

    public void openTelephone(View v){
        Intent openTel = new Intent(this, Telephone.class);
        startActivity(openTel);
    }
}
