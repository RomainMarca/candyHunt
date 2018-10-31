package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);

        TextView score = findViewById(R.id.score);
        TextView bestScore = findViewById(R.id.best_score);
        Button buttonAgain = findViewById(R.id.button_again);

        score.setText("Votre score :" + Singleton.getInstance().getIndex());
        bestScore.setText("Meilleur score :" + Singleton.getInstance().getIndex());

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(DeadActivity.this, GameArenaActivity.class);
                startActivity(intent);
            }
        });

        TextView retour = findViewById(R.id.close);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(DeadActivity.this , MainActivity.class);
                DeadActivity.this.startActivity(goToMenu);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Polymorphisme. Vide la méthode onBackPressed pour empêcher son utilisation pendant la partie


    }
}
