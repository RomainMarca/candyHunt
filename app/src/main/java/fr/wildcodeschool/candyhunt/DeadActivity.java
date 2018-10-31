package fr.wildcodeschool.candyhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);

        TextView score = findViewById(R.id.score);
        score.setText("Votre score :" + Singleton.getInstance().getIndex());


    }
}
