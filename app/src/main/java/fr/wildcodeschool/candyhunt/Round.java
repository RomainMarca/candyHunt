package fr.wildcodeschool.candyhunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Round {

    float timerDuration;
    int nbCandies;
    Candie candieTarget;
    //int candiesDifficulty; //Correspond à la difficulté des bonbons sélectionnés pour ce round
    ArrayList<Candie> candiesStock = new ArrayList<>();
    ArrayList<Candie> candiesToInstantiate = new ArrayList<>();
    Context context;
    int scoreGain;
    CountDownTimer timer;
    final static int MIN = 2;
    final static int MAX = 98;

    /*CONSTRUCTOR*/
    public Round(float timerDuration, int nbCandies, Candie candieTarget, int candiesDifficulty, Context context, int scoreGain) {
        this.timerDuration = timerDuration;
        this.nbCandies = nbCandies;
        this.candieTarget = candieTarget;
        this.context = context;
        this.scoreGain = scoreGain;

        if(candiesDifficulty == 0) {
            this.candiesStock = Singleton.getInstance().getCandiesLevel1();
        } else if (candiesDifficulty == 1 ) {
            this.candiesStock = Singleton.getInstance().getCandiesLevel2();
        } else {
            this.candiesStock = Singleton.getInstance().getAllCandiesStock();
        }
    }

    /*GETTERS AND SETTERS*/

    public int getScoreGain() {
        return scoreGain;
    }

    public void setScoreGain(int scoreGain) {
        this.scoreGain = scoreGain;
    }

    public ArrayList<Candie> getCandiesToInstantiate() {
        return candiesToInstantiate;
    }

    public void setCandiesToInstantiate(ArrayList<Candie> candiesToInstantiate) {
        this.candiesToInstantiate = candiesToInstantiate;
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

    public void generateCandies() {

        ArrayList<Candie> candiesClone = (ArrayList<Candie>) this.candiesStock.clone();
        candiesClone.remove(this.candieTarget);
        Collections.shuffle(candiesClone);


        this.candieTarget.setHorizontalLocation(generateRandomInteger(4, 96));
        this.candieTarget.setVerticalLocation(generateRandomInteger(4, 96));

        this.candiesToInstantiate.add(this.candieTarget);
        Candie newCandie;

        for(int i = 0 ; i < Math.min(this.nbCandies , candiesClone.size()) - 1; i ++) {

            newCandie = candiesClone.get(i);
            newCandie = randomPositionCandie(newCandie);
            int j = 30;

            while (positionIsAlreadyUsed(this.candiesToInstantiate, newCandie) && j > 0) {
                newCandie = randomPositionCandie(newCandie);
                j--;
            }
            this.candiesToInstantiate.add(newCandie);
        }
    }

    public boolean positionIsAlreadyUsed(ArrayList<Candie> candiesToCheck, Candie newCandie) {

        for(Candie candieToCheck : candiesToCheck) {

            boolean xIsTooClose = Math.abs(candieToCheck.getHorizontalLocation()-newCandie.getHorizontalLocation()) < 20f;
            boolean yIsTooClose = Math.abs(candieToCheck.getVerticalLocation()-newCandie.getVerticalLocation()) < 20f;

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

    public Candie randomPositionCandie(Candie myNewCandie) {

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

        timer = new CountDownTimer((long) timerDuration, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText(millisUntilFinished / 1000 + " s.");
            }

            public void onFinish() {
                defeat();
            }
        }.start();
    }

    public void defeat() {
        MediaPlayer music = MediaPlayer.create( context, R.raw.whoo);
        music.start();
        Activity arena = (Activity) context;
        Intent gotoDead = new Intent(context, DeadActivity.class);
        Singleton.getInstance().setScore(Singleton.getInstance().getIndex());

        if(Singleton.getInstance().getDifficultyLevel() == 0) {
            if (Singleton.getInstance().getBestscore0() < Singleton.getInstance().getScore()) {
                Singleton.getInstance().setBestscore0(Singleton.getInstance().getScore());
            }
        } else if(Singleton.getInstance().getDifficultyLevel() == 1) {
            if (Singleton.getInstance().getBestscore1() < Singleton.getInstance().getScore()) {
                Singleton.getInstance().setBestscore1(Singleton.getInstance().getScore());
            }
        } else {
            if (Singleton.getInstance().getBestscore2() < Singleton.getInstance().getScore()) {
                Singleton.getInstance().setBestscore2(Singleton.getInstance().getScore());
            }
        }




        Singleton.getInstance().setIndex(0);
        timer.cancel();
        context.startActivity(gotoDead);
        arena.finish();
    }

    public void success() {
        MediaPlayer music = MediaPlayer.create( context, R.raw.bul);
        music.start();
        Singleton.getInstance().incrementIndex(1);
        Singleton.getInstance().getPlayers().get(0).addScore(scoreGain);
        Activity arenaActivity = (Activity) context;
        timer.cancel();
        arenaActivity.recreate();
    }

    public void imageTargetCandie(){
        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        ImageView targetImage = (ImageView) rootView.findViewById(R.id.target);
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) targetImage.getLayoutParams();
        params.width = 140;
        targetImage.setImageResource(candieTarget.getCandieResourceId());
        }
}