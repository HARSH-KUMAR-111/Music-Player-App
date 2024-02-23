package com.example.exp4ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Play(View v){
        if(player ==null){
            player =MediaPlayer.create(this,R.raw.hanuman);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp){
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void Pause(View v) {
        if(player !=null){
            player.pause();
        }
    }
    public void Stop(View v) {
        stopPlayer();
    }
    private void stopPlayer(){
        if(player!= null){
            player.release();
            player= null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }


}