package com.hacksite.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText et1, et2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv3 = findViewById(R.id.tv3);
        spinner = findViewById(R.id.spinner);

        String []opciones = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);
    }

    public void operar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        String selec = spinner.getSelectedItem().toString();
        switch (selec) {
            case "sumar": {
                int suma = nro1 + nro2;
                String res = String.valueOf(suma);
                tv3.setText(res);
                break;
            }
            case "restar": {
                int resta = nro1 - nro2;
                String res = String.valueOf(resta);
                tv3.setText(res);
                break;
            }
            case "multiplicar": {
                int multiplicar = nro1 * nro2;
                String res = String.valueOf(multiplicar);
                tv3.setText(res);
                break;
            }
            case "dividir": {
                int dividir = nro1 / nro2;
                String res = String.valueOf(dividir);
                tv3.setText(res);
                break;
            }
        }
    }
}
