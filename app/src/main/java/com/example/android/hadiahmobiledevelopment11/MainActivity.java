package com.example.android.hadiahmobiledevelopment11;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer bgMusic;
    private Button mButtonMsg;

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
