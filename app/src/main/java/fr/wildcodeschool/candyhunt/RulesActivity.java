package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        TextView intent = findViewById(R.id.rules);
        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToArena = new Intent(RulesActivity.this , GameArenaActivity.class);
                RulesActivity.this.startActivity(goToArena);
            }
        });

    }
}
