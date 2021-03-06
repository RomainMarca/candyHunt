package fr.wildcodeschool.candyhunt;


import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

class Singleton {

    private static final Singleton ourInstance = new Singleton();
    private final static int NBCANDIESLEVEL1 = 18;
    private final static int NBCANDIESLEVEL2 = 18;
    ArrayList<Player> players = new ArrayList();
    private ArrayList<Candie> allCandiesStock = new ArrayList<>();
    private ArrayList<Candie> candiesLevel1 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel2 = new ArrayList<>();
    private ArrayList<Round> mRounds = new ArrayList<>();
    private int index;
    private int score;
    private int bestscore0;
    private int bestscore1;
    private int bestscore2;

    private int difficultyLevel;


    private Singleton() {

        index = 0;
        score = 0;
        difficultyLevel = 0;
    }

    static Singleton getInstance() {
        return ourInstance;
    }

    /*Getters and Setters*/

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getBestscore0() {
        return bestscore0;
    }

    public void setBestscore0(int bestscore0) {
        this.bestscore0 = bestscore0;
    }

    public int getBestscore1() {
        return bestscore1;
    }

    public void setBestscore1(int bestscore1) {
        this.bestscore1 = bestscore1;
    }

    public int getBestscore2() {
        return bestscore2;
    }

    public void setBestscore2(int bestscore2) {
        this.bestscore2 = bestscore2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Round> getmRounds() {
        return mRounds;
    }

    public void setmRounds(ArrayList<Round> mRounds) {
        this.mRounds = mRounds;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Candie> getAllCandiesStock() {
        return allCandiesStock;
    }

    public void setAllCandiesStock(ArrayList<Candie> allCandiesStock) {
        this.allCandiesStock = allCandiesStock;
    }

    public ArrayList<Candie> getCandiesLevel1() {
        return candiesLevel1;
    }

    public void setCandiesLevel1(ArrayList<Candie> candiesLevel1) {
        this.candiesLevel1 = candiesLevel1;
    }

    public ArrayList<Candie> getCandiesLevel2() {
        return candiesLevel2;
    }

    public void setCandiesLevel2(ArrayList<Candie> candiesLevel2) {
        this.candiesLevel2 = candiesLevel2;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    /*Methods*/

    public void initCandies() {
        int candieIndex = 1;

        String resourceName;
        int IdToSet;

        for (int i = 1; i <= NBCANDIESLEVEL1; i++) {
            resourceName = "g" + 1 + "c" + i;
            IdToSet = getId(resourceName, R.drawable.class);
            candiesLevel1.add(new Candie(IdToSet, 1));
            resourceName = "g" + 2 + "c" + i;
            IdToSet = getId(resourceName, R.drawable.class);
            candiesLevel2.add(new Candie(IdToSet, 2));
        }
        allCandiesStock.addAll(candiesLevel1);
        allCandiesStock.addAll(candiesLevel2);
    }

    private int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

    public Candie getCandieById(int candieId) {
        ArrayList<Candie> candies = Singleton.getInstance().getAllCandiesStock();
        for (Candie candie : candies) {
            if (candie.getCandieResourceId() == candieId) {
                return candie;
            }
        }
        //If none target candie encountered
        Candie candie = Singleton.getInstance().getAllCandiesStock().get(0);
        return candie;
    }

    public void initPlayers() {
        Player player1 = new Player(0, "player1");
        Player player2 = new Player(0, "player2");
        players.add(player1);
        players.add(player2);
    }

    public void initRounds(int nbRounds, Context context, int difficultyLevel) {
        mRounds.clear();

        for (int i = 0; i <= nbRounds; i++) {
            int nbCandy = numberCandy(i);
            int scoreGain = adjustScoreGain(i);
            Candie target;
            float duration = 0f;

            if(difficultyLevel == 0) {
                target = PickRandomTarget(candiesLevel1);
                duration = timeDurationRound(difficultyLevel,7000, 6000, 5000);
            } else if (difficultyLevel == 1) {
                target = PickRandomTarget(candiesLevel2);
                duration = timeDurationRound(difficultyLevel,5000, 4000, 3000);
            } else {
                target = PickRandomTarget(allCandiesStock);
                duration = timeDurationRound(difficultyLevel,4000, 3000, 2000);
            }
            Round round = new Round(duration, nbCandy, target, difficultyLevel, context, scoreGain);
            mRounds.add(round);
        }
    }

    public int adjustScoreGain(int i) {
        int score;
        score = (i*5)+i;
        return score;
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
        } else if (i >= 10 && i < 20){
            return 1;
        } else {
            return 2;
        }
    }

    public int numberCandy(int i) {
        return i+3;
    }

    public float timeDurationRound(int difficultyLevel, float timeDuration0, float timeDuration1, float timeDuration2) {
        if (difficultyLevel == 0) {
            return timeDuration0;
        } else if (difficultyLevel == 1) {
            return timeDuration1;
        } else {
            return timeDuration2;
        }
    }

    public void incrementIndex(int value) {
        this.index += value;
    }

}
