package com.example.android.hadiahmobiledevelopment11;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PesanActivity extends AppCompatActivity {
    private MediaPlayer bgMusic;
    private ImageView mImageBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        mImageBg = findViewById(R.id.image_bg_pesan);
        mImageBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bgMusic.isPlaying())
                    bgMusic.pause();
                else
                    bgMusic.start();
            }
        });
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
