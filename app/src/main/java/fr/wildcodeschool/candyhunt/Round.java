package fr.wildcodeschool.candyhunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import cn.iwgang.countdownview.CountdownView;

public class Round {

    float timerDuration;
    int nbCandies;
    Candie candieTarget;
    int candiesDifficulty; //Correspond à la difficulté des bonbons sélectionnés pour ce round
    ArrayList<Candie> candiesStock = new ArrayList<>();
    ArrayList<Candie> candiesToInstantiate = new ArrayList<>();
    Context context;
    //CountdownView countDownTimer;

    final static int MIN = 2;
    final static int MAX = 98;

    /*CONSTRUCTOR*/
    public Round(float timerDuration, int nbCandies, Candie candieTarget, int candiesDifficulty, Context context) {
        this.timerDuration = timerDuration;
        this.nbCandies = nbCandies;
        this.candieTarget = candieTarget;
        this.candiesDifficulty = candiesDifficulty;
        this.context = context;

        if(candiesDifficulty == 0) {
            this.candiesStock = Singleton.getInstance().getCandiesLevel1();
        } else if (candiesDifficulty == 1 ) {
            this.candiesStock = Singleton.getInstance().getCandiesLevel2();
        } else {
            this.candiesStock = Singleton.getInstance().getAllCandiesStock();
        }
    }

    /*GETTERS AND SETTERS*/

    public ArrayList<Candie> getCandiesToInstantiate() {
        return candiesToInstantiate;
    }

    public void setCandiesToInstantiate(ArrayList<Candie> candiesToInstantiate) {
        this.candiesToInstantiate = candiesToInstantiate;
    }

    public int getCandiesDifficulty() {
        return candiesDifficulty;
    }

    public void setCandiesDifficulty(int candiesDifficulty) {
        this.candiesDifficulty = candiesDifficulty;
    }

    public ArrayList<Candie> getCandiesStock() {
        return candiesStock;
    }

    public void setCandiesStock(ArrayList<Candie> candies) {
        this.candiesStock = candies;
    }

    public Candie getCandieTarget() {
        return candieTarget;
    }

    public void setCandieTarget(Candie candieTarget) {
        this.candieTarget = candieTarget;
    }

    public float getTimerDuration() {
        return timerDuration;
    }

    public void setTimerDuration(float timerDuration) {
        this.timerDuration = timerDuration;
    }

    public int getNbCandies() {
        return nbCandies;
    }

    public void setNbCandies(int nbCandies) {
        this.nbCandies = nbCandies;
    }

    //TODO Méthode pour gérer le Timer
    //TODO Success (Méthode classique, ou bien mettre en place un listener?)
    //TODO defeat (pareil. Méthode classique, ou bien mettre en place un listener ?)
    //TODO Méthode CLEAR. Delete tous les bonbons et finish le round
    //TODO Méthode WinRound. Animation victoire + incremente le compteur de vicoire et relance un nouveau round
    //TODO Méthode LoseRound. Animation defaite + stop le compteur de vicoire et arrete le jeu.
    //TODO Méthode pickARandomTargetCandie
    //TODO Méthode initiateTousLesBonbons (+ pimper cette méthode pour ajuster la difficulté?).
    //TODO Méthode generateRandomPosition
    //TODO (facultatif or not?) Créer une méthode qui stocke tout un tas de bonbons randoms
    //TODO Méthode : Générer randomly une position verticale + une position horizontale (nouvelle à chaque fois)
    //TODO Méthode : Affichage des bonbons
    //TODO Méthode : clear
    //TODO Méthode : Lancer Round (1 : Clear 2 : Affichage des bonbons)

    public void generateCandies() {

        this.candieTarget.setHorizontalLocation(generateRandomInteger(4, 96));
        this.candieTarget.setVerticalLocation(generateRandomInteger(4, 96));
        this.candiesToInstantiate.add(this.candieTarget);
        Candie newCandie;

        for(int i = 0 ; i < this.nbCandies - 1 ; i ++) {
            do {
                newCandie = generateACandie();
            } while (newCandie.getCandieResourceId() == candieTarget.getCandieResourceId() || positionIsAlreadyUsed(this.candiesToInstantiate, newCandie));
        this.candiesToInstantiate.add(generateACandie());
        }
    }

    public boolean positionIsAlreadyUsed(ArrayList<Candie> candiesToCheck, Candie newCandie) {

        for(Candie candieToCheck : candiesToCheck) {

            boolean xIsTooClose = Math.abs(candieToCheck.getHorizontalLocation()-newCandie.getHorizontalLocation()) < 20;
            boolean yIsTooClose = Math.abs(candieToCheck.getVerticalLocation()-newCandie.getVerticalLocation()) < 20;
            float distanceFromX = Math.abs(candieToCheck.getHorizontalLocation()-newCandie.getHorizontalLocation());
            float distanceFromY = Math.abs(candieToCheck.getVerticalLocation()-newCandie.getVerticalLocation());
            int distanceFromXint = (int) distanceFromX;
            int distanceFromYint = (int) distanceFromY;

            if(xIsTooClose && yIsTooClose) {
                return true;
            }
        }
        return false;
    }

    public void instantiateCandiesInGameArena(ArrayList<Candie> candiesToInstantiate) {

        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        ConstraintLayout arena =  (ConstraintLayout) rootView.findViewById(R.id.arena);

        for(final Candie candie : candiesToInstantiate) {

            ImageView newCandie = new ImageView(context);
            newCandie.setImageResource(candie.getCandieResourceId());
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams (convertDpToPixel(candie.getCandieDimension()), convertDpToPixel(candie.getCandieDimension()));

            newCandie.setLayoutParams(lp);
            arena.addView(newCandie);
            newCandie.setId(candie.getCandieResourceId());

            ConstraintSet cs = new ConstraintSet();
            cs.clone(arena);
            cs.connect(newCandie.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
            cs.connect(newCandie.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
            cs.connect(newCandie.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
            cs.connect(newCandie.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);

            cs.setHorizontalBias(newCandie.getId(), candie.getHorizontalLocation()/100);
            cs.setVerticalBias(newCandie.getId(), candie.getVerticalLocation()/100);
            cs.applyTo(arena);

            final Candie localCandieTarget = this.candieTarget;

            newCandie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(candie.getCandieResourceId() == localCandieTarget.getCandieResourceId() ) {
                        success();

                    } else {
                        defeat();

                    }
                }
            });
        }
    }

    public int convertDpToPixel(float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    public Candie generateACandie() {

        int maxIndexCandieToPick = this.candiesStock.size()-1;
        int indexCandieToPick = generateRandomInteger(0, maxIndexCandieToPick); //TODO Rajouter ici une vérification (pas de position double). Une méthode basique et une boucle while feront l'affaire
        Candie myNewCandie = this.candiesStock.get(indexCandieToPick);
        myNewCandie.setHorizontalLocation(generateRandomInteger(0, 100));
        myNewCandie.setVerticalLocation(generateRandomInteger(0, 100));

        return myNewCandie;
    }

    public int generateRandomInteger(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }

    public void launchRound(){
        imageTargetCandie();
        launchTimer();
        generateCandies();
        instantiateCandiesInGameArena(candiesToInstantiate);
    }

    public void launchTimer() {

        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        final TextView mTextField =  (TextView) rootView.findViewById(R.id.timer);

        new CountDownTimer((long) timerDuration, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText(millisUntilFinished / 1000 + " s.");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                mTextField.setText("Perdu !");
                defeat();
            }
        }.start();
    }

    public void defeat() {
        //TODO Il se passe des trucs ici
        Intent gotoDead = new Intent(context, DeadActivity.class);
        context.startActivity(gotoDead);
        Singleton.getInstance().setIndex(0);
    }

    public void success() {
        Toast.makeText(context, "BRAVO", Toast.LENGTH_SHORT).show();
        Singleton.getInstance().setIndex(+1);
        Activity arenaActivity = (Activity) context;
        arenaActivity.recreate();
    }
    public void imageTargetCandie() {
        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        ImageView targetImage = (ImageView) rootView.findViewById(R.id.target);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) targetImage.getLayoutParams();
        params.width = 140;
        targetImage.setImageResource(candieTarget.getCandieResourceId());

        }

    /*public void reLaunchRound() {
        //Todo relancer <round +1>
        countDownTimer.clear;
    }*/

}
