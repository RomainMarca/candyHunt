package fr.wildcodeschool.candyhunt;

import java.util.ArrayList;

public class Round {

    float timerDuration;
    int nbCandies;
    String candieTargetId;
    int candiesDifficulty; //Correspond à la difficulté des bonbons sélectionnés pour ce round
    ArrayList<Candie> candies = new ArrayList<>();

    /*CONSTRUCTOR*/
    public Round(float timerDuration, int nbCandies, String candieTargetId, int candiesDifficulty) {
        this.timerDuration = timerDuration;
        this.nbCandies = nbCandies;
        this.candieTargetId = candieTargetId;
        this.candiesDifficulty = candiesDifficulty;
    }

    /*GETTERS AND SETTERS*/

    public int getCandiesDifficulty() {
        return candiesDifficulty;
    }

    public void setCandiesDifficulty(int candiesDifficulty) {
        this.candiesDifficulty = candiesDifficulty;
    }

    public ArrayList<Candie> getCandies() {
        return candies;
    }

    public void setCandies(ArrayList<Candie> candies) {
        this.candies = candies;
    }

    public String getCandieTargetId() {
        return candieTargetId;
    }

    public void setCandieTargetId(String candieTargetId) {
        this.candieTargetId = candieTargetId;
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

    public void EndRound(ArrayList candies){
        candies.clear();

    }
}
