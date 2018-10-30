package fr.wildcodeschool.candyhunt;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Round {

    float timerDuration;
    int nbCandies;
    //String candieTargetId;
    Candie candieTarget;
    int candiesDifficulty; //Correspond à la difficulté des bonbons sélectionnés pour ce round
    ArrayList<Candie> candiesStock = new ArrayList<>();

    final static int MIN = 2;
    final static int MAX = 98;

    /*CONSTRUCTOR*/
    public Round(float timerDuration, int nbCandies, Candie candieTarget, int candiesDifficulty) {
        this.timerDuration = timerDuration;
        this.nbCandies = nbCandies;
        this.candieTarget = candieTarget;
        this.candiesDifficulty = candiesDifficulty;
    }

    /*GETTERS AND SETTERS*/

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


    public Candie generateACandie() {

        int maxIndexCandieToPick = candiesStock.size()-1;
        int indexCandieToPick = generateRandomInteger(0, maxIndexCandieToPick);
        Candie myNewCandie = candiesStock.get(indexCandieToPick);
        myNewCandie.setHorizontalLocation(generateRandomInteger(0, 100));
        myNewCandie.setVerticalLocation(generateRandomInteger(0, 100));

        return myNewCandie;
    }



    public int generateRandomInteger(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }

}
