package fr.wildcodeschool.candyhunt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;

public class GameArenaActivity extends AppCompatActivity{

    int timeDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_arena_activity);

        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player(0,"player_one");
        players.add(player);


        GameDieHard dieHard = new GameDieHard(true,1,players,50);

        CountdownView countDownTimer = findViewById(R.id.countdown);
        countDownTimer.start(timeDuration);



    }
}
