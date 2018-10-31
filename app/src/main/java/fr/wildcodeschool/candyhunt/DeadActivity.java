package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);


        TextView score = findViewById(R.id.score);
        score.setText("Votre score :" + Singleton.getInstance().getIndex());

        TextView retour = findViewById(R.id.close);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(DeadActivity.this , MainActivity.class);
                DeadActivity.this.startActivity(goToMenu);
            }
        });
    }
}
