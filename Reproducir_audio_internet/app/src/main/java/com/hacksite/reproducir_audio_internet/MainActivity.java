package com.hacksite.reproducir_audio_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View v){
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource("http://www.freesound.org/data/previews/137/137227_1735491-lq.mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e){

        }
    }
}
