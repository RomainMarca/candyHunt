package fr.wildcodeschool.candyhunt;

public class Player {

    private int score;
    private int bestScore;
    private String playerId;

    /*CONSTRUCTOR*/
    public Player(int score, String playerId) {
        this.score = score;
        this.bestScore = 0;
        this.playerId = playerId;
    }

    /*GETTERS AND SETTERS*/

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void addScore(int moreScore) {
        score += moreScore;
    }

    //TODO Ajouter un dispositif Firebase pour stocker de manière définitive le score des joueurs? (facultatif)


}
