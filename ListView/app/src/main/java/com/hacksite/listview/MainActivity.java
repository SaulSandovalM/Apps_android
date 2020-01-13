package com.hacksite.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] paises = {
        "Argentina",
        "Chile",
        "Paraguay",
        "Bolivia",
        "Peru",
        "Ecuador",
        "Brasil",
        "Colombia",
        "Venezuela",
        "Uruguay"
    };
    private String [] habitantes = {
        "40000000",
        "17000000",
        "6500000",
        "10000000",
        "30000000",
        "14000000",
        "183000000",
        "44000000",
        "29000000",
        "3500000"
    };
    private TextView tvl;
    private ListView lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvl = findViewById(R.id.tv1);
        lvl = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (
                this, android.R.layout.simple_list_item_1, paises);
        lvl.setAdapter(adapter);
        lvl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvl.setText("Poblacion de " + lvl.getItemAtPosition(position) + " es " + habitantes[position]);
            }
        });
    }
}
