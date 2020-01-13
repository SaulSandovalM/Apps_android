package com.hacksite.audio_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play (View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("file:///sdcard" + "/Music/anthem.mp3");
        intent.setDataAndType(data, "audio/mp3");
        startActivity(intent);
    }
}
