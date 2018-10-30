package fr.wildcodeschool.candyhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Singleton.getInstance().initCandies();

        Button button = findViewById(R.id.button_intent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToArena = new Intent(MainActivity.this , GameArenaActivity.class);
                MainActivity.this.startActivity(goToArena);
            }
        });
    }
}
