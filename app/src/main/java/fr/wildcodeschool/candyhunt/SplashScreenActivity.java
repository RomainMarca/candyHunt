package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.porte);
        ImageView logoApp = findViewById(R.id.logo);
        ImageView buttonStart = findViewById(R.id.start);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent map = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(map);
            }
        });
    }
}




