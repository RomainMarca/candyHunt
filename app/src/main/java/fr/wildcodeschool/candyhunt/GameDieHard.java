package fr.wildcodeschool.candyhunt;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

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

    public Candie PickRandomTarget(ArrayList<Candie> candies){

        int possibleIndex =  candies.size()-1;
        Random random = new Random();
        int candieIndex = random.nextInt(possibleIndex + 1 - 0) + 0;

        return candies.get(candieIndex);


    }

}
