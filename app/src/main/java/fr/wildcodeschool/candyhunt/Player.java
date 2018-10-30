package fr.wildcodeschool.candyhunt;

public class Player {

    private int score;
    private String playerId;

    /*CONSTRUCTOR*/
    public Player(int score, String playerId) {
        this.score = score;
        this.playerId = playerId;
    }

    /*GETTERS AND SETTERS*/
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

    //TODO Ajouter un dispositif Firebase pour stocker de manière définitive le score des joueurs? (facultatif)


}
