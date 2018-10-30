package fr.wildcodeschool.candyhunt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.iwgang.countdownview.CountdownView;

public class GameArenaActivity extends AppCompatActivity{

    int timeDuration=8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_arena_activity);

        CountdownView countDownTimer = findViewById(R.id.countdown);
        countDownTimer.start(timeDuration);

    }
}
