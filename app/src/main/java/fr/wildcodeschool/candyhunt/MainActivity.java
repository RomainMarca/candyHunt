package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singleton.getInstance().initCandies();
        Singleton.getInstance().initPlayers();

        ImageView gosht = findViewById(R.id.iv_g);
        ImageView vamp = findViewById(R.id.iv_vamp);
        ImageView witch = findViewById(R.id.iv_witch);

        gosht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRules = new Intent(MainActivity.this , RulesActivity.class);
                Singleton.getInstance().setDifficultyLevel(0);
                startActivity(goToRules);
            }
        });

        vamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRules = new Intent(MainActivity.this , RulesActivity.class);
                Singleton.getInstance().setDifficultyLevel(2);
                MainActivity.this.startActivity(goToRules);
            }
        });

        witch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRules = new Intent(MainActivity.this , RulesActivity.class);
                Singleton.getInstance().setDifficultyLevel(1);
                MainActivity.this.startActivity(goToRules);
            }
        });
    }
}
