package com.alejandrodiaz.mistareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnNewWork;
    Button btnAllWorks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewWork = (Button) findViewById(R.id.btnNewWork);
        btnAllWorks = (Button) findViewById(R.id.btnAllWorks);

        btnNewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewWorkActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Nueva Tarea",Toast.LENGTH_SHORT).show();
            }
        });

        btnAllWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllWorksActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Todas las Tareas",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
