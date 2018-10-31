package fr.wildcodeschool.candyhunt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;

public class GameArenaActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_arena_activity);

        int difficultyLevel = 2;

        GameDieHard dieHard = new GameDieHard(false,1,Singleton.getInstance().getPlayers(),50, this, difficultyLevel);
        dieHard.launchGame();
    }

    @Override
    public void onBackPressed() {
        //Polymorphisme. Vide la méthode onBackPressed pour empêcher son utilisation pendant la partie
    }
}
