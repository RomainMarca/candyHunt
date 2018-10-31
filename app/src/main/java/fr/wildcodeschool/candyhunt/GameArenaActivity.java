package fr.wildcodeschool.candyhunt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;

public class GameArenaActivity extends AppCompatActivity{

    int timeDuration=8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_arena_activity);

        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player(0,"player_one");
        players.add(player);


        GameDieHard dieHard = new GameDieHard(false,1,players,50, this);
        dieHard.LaunchGame();

        /*CountdownView countDownTimer = findViewById(R.id.countdown);
        countDownTimer.start(timeDuration);*/

        //TODO DEBUG TO DELETE DEBUT


        /*Candie candieTargetTest = Singleton.getInstance().getAllCandiesStock().get(0);
        Round round = new Round(6000, 10, candieTargetTest, 2, GameArenaActivity.this);
        round.generateCandies();
        ArrayList<Candie> candiesToInstantiate = Singleton.getInstance().getAllCandiesStock();
        round.instantiateCandiesInGameArena(candiesToInstantiate);*/


        //TODO DEBUG TO DELETE FIN

    }
}
