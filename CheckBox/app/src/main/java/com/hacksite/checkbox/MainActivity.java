package com.hacksite.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv3;
    private CheckBox checkBox1, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv3 = findViewById(R.id.tv3);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
    }

    public void operar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        String res = "";
        if (checkBox1.isChecked()){
            int suma = nro1 + nro2;
            res = "La suma es: " + suma;
        }
        if (checkBox2.isChecked()){
            int resta = nro1 - nro2;
            res =res + "La resta es: " + resta;
        }
        tv3.setText(res);
    }
}
