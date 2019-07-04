package com.example.android.hadiahmobiledevelopment11;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer bgMusic;
    private Button mButtonMsg;
    private ImageView mImageBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonMsg = findViewById(R.id.button_msg);
        mButtonMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PesanActivity.class);
                startActivity(intent);
            }
        });

        mImageBg = findViewById(R.id.image_bg_main);
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
    protected void onDestroy() {
        if (bgMusic != null) {
            bgMusic.release();
            bgMusic = null;
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bgMusic == null) {
            bgMusic = MediaPlayer.create(this, R.raw.main_bgm);
            bgMusic.setLooping(true);
        }
        bgMusic.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bgMusic != null) bgMusic.pause();
    }

}
