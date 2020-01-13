package com.hacksite.play_pause_continue_pause;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Button b5;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b5 = findViewById(R.id.button5);
    }

    public void play(View v){
        destruir();
        mp = MediaPlayer.create(this, R.raw.song);
        mp.start();
        String op = b5.getText().toString();
        if (op.equals("no reproducir en loop")){
            mp.setLooping(false);
        } else {
            mp.setLooping(true);
        }
    }

    private void destruir() {
        if (mp != null){
            mp.release();
        }
    }

    public void pause(View v){
        if (mp != null && mp.isPlaying()){
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View v){
        if (mp != null && !mp.isPlaying()){
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void stop(View v){
        if (mp != null){
            mp.stop();
            posicion = 0;
        }
    }

    public void loop(View v){
        stop(null);
        String op = b5.getText().toString();
        if (op.equals("no reproducir en loop")) {
            b5.setText("reproducir en forma de loop");
        } else {
            b5.setText("no reproducir en forma de loop");
        }
    }
}
