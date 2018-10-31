package fr.wildcodeschool.candyhunt;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameDieHard {

    int nbPlayers;
    ArrayList<Player> players = new ArrayList<>();
    int nbRounds;
    Context context;
    int difficultyLevel;


    /*CONSTRUCTOR*/
    public GameDieHard(boolean timer, int nbPlayers, ArrayList<Player> players, int nbRounds, Context context, int difficultyLevel) {
        this.nbPlayers = nbPlayers;
        this.players = players;
        this.nbRounds = nbRounds;
        this.context = context;
        this.difficultyLevel = difficultyLevel;
    }

    /*GETTERS AND SETTERS*/

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

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

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    //TODO méthode InitiateNewRound
    //TODO méthode InitiateAllRounds

    public void launchGame() {

                if (Singleton.getInstance().getIndex() == 0) {
                    Singleton.getInstance().initRounds(nbRounds, context, difficultyLevel);
                }

                Singleton.getInstance().getmRounds().get(Singleton.getInstance().getIndex()).launchRound();
    }

}