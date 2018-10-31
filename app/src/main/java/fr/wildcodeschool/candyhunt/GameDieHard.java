package fr.wildcodeschool.candyhunt;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameDieHard {

    int nbPlayers;
    ArrayList<Player> players = new ArrayList<>();
    int nbRounds;
    ArrayList<Round> mRounds = new ArrayList<>();
    Context context;

    /*CONSTRUCTOR*/
    public GameDieHard(boolean timer, int nbPlayers, ArrayList<Player> players, int nbRounds, Context context) {
        this.nbPlayers = nbPlayers;
        this.players = players;
        this.nbRounds = nbRounds;
        this.context = context;
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

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    //TODO méthode InitiateNewRound
    //TODO méthode InitiateAllRounds

    public void LaunchGame(final TextView rules, final TextView close) {
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules.setVisibility(View.INVISIBLE);
                close.setVisibility(View.INVISIBLE);

                initRounds(nbRounds);
            }
        });
    }

    public void endRound() {
        //TODO clear la liste des candies en cour
    }

    public void initRounds(int nbRounds) {
        for (int i = 1; i <= nbRounds; i++) {
            int dificulty = levelDificulty(i);
            int nbCandy = numberCandy(i);
            float duration = timeDurationRound(dificulty,5000, 4000, 3000);
            Candie target = PickRandomTarget(Singleton.getInstance().getAllCandiesStock());
            Round round = new Round(duration, nbCandy, target, dificulty, context);
            mRounds.add(round);
        }
    }

    public Candie PickRandomTarget(ArrayList<Candie> candies){
        int possibleIndex =  candies.size()-1;
        Random random = new Random();
        int candieIndex = random.nextInt(possibleIndex + 1 - 0) + 0;

        return candies.get(candieIndex);
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

    public float timeDurationRound(int dificulty, float timeDuration0, float timeDuration1, float timeDuration2) {
        if (dificulty == 0) {
            return timeDuration0;
        } else if (dificulty == 1) {
            return timeDuration1;
        }else {
            return timeDuration2;
        }
    }

    /*public void onResult() {
        if (click == target) {
            Player.counter +1
            reLaunchRound(+1);
        } else {
            Player.counter(view);
            intent mainActivity;
        }
    }*/
}