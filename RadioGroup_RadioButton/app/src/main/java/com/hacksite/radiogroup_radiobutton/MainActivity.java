package com.hacksite.radiogroup_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv3;
    private RadioButton r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv3 = findViewById(R.id.tv3);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
    }

    public void operar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        if (r1.isChecked()){
            int suma = nro1 + nro2;
            String res = String.valueOf(suma);
            tv3.setText(res);
        } else if (r2.isChecked()) {
            int resta = nro1 - nro2;
            String res = String.valueOf(resta);
            tv3.setText(res);
        }
    }
}
