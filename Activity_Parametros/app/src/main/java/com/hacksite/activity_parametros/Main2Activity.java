package com.hacksite.activity_parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView = findViewById(R.id.webView);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("direccion");
        webView.loadUrl("https://"+dato);
    }
}
