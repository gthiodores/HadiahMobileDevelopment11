package com.example.android.hadiahmobiledevelopment11;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PesanActivity extends AppCompatActivity {
    MediaPlayer bgMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bgMusic != null) {
            bgMusic.release();
            bgMusic = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        bgMusic = MediaPlayer.create(this, R.raw.pesan_bgm);
        bgMusic.setLooping(true);
        bgMusic.start();
    }
}
