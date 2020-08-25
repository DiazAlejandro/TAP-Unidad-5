package mx.edu.itoaxaca.concurredplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Recommendations extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> recommendations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
        listView = (ListView) findViewById(R.id.listViewRec);
        recommendations = new ArrayList<String>();
        recommendations.add(getString(R.string.rec1));
        recommendations.add(getString(R.string.rec2));
        recommendations.add(getString(R.string.rec3));
        recommendations.add(getString(R.string.rec4));
        recommendations.add(getString(R.string.rec5));
        recommendations.add(getString(R.string.rec6));
        recommendations.add(getString(R.string.rec7));
        recommendations.add(getString(R.string.rec8));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recommendations){
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        listView.setAdapter(adapter);

    }

    public void openMain(View v){
        Intent main = new Intent(this, MainActivity.class);
        finish();
        startActivity(main);
    }
}
