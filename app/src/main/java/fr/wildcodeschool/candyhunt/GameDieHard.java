package fr.wildcodeschool.candyhunt;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GameDieHard {

    int nbPlayers;
    ArrayList<Player> players = new ArrayList<>();
    int nbRounds;
    ArrayList<Round> rounds = new ArrayList<>();

    /*CONSTRUCTOR*/
    public GameDieHard(boolean timer, int nbPlayers, ArrayList<Player> players, int nbRounds) {
        this.nbPlayers = nbPlayers;
        this.players = players;
        this.nbRounds = nbRounds;
    }

    /*GETTERS AND SETTERS*/

    public int getNbPlayers() {
        return nbPlayers;
    }

    public void setNbPlayers(int nbPlayers) {
        this.nbPlayers = nbPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getNbRounds() {
        return nbRounds;
    }

    public void setNbRounds(int nbRounds) {
        this.nbRounds = nbRounds;
    }


    //TODO méthode InitiateNewRound
    //TODO méthode InitiateAllRounds

    public void LaunchGame(final TextView rules, final TextView close) {
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules.setVisibility(View.INVISIBLE);
                close.setVisibility(View.INVISIBLE);

            }
        });
    }

    public void initRounds(ArrayList rounds, int nbRounds) {
        for (int i = 1; i <= nbRounds; i++) {
            int dificulty = levelDificulty(i);
            int nbCandy = numberCandy(i);
            int duration = durationRound(dificulty, 5000, 4000, 3000);

            rounds.add();
        }
    }

    public int levelDificulty(int i) {
        if (i < 10) {
            return 0;
        } else if (i > 10 && i < 20){
            return 1;
        } else {
            return 2;
        }
    }

    public int numberCandy(int i) {
        return i+3;
    }

    public int durationRound(int dificulty, int duration0, int duration1, int duration2) {
        if (dificulty == 0) {
            return duration0;
        } else if (dificulty == 1) {
            return duration1;
        }else {
            return duration2;
        }
    }

    
}
