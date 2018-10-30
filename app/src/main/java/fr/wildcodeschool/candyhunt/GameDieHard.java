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

}
