package fr.wildcodeschool.candyhunt;

import android.widget.ImageView;

public class Candie {

    //TODO Imageview direct du bonbon ? Ou bien bitmap ? A décider et à mettre en place

    private float candieDimension = 10f;
    private float speed = 0f;
    private float horizontalLocation;
    private float verticalLocation;
    private int candieDifficulty;
    private ImageView candieImage;
    private int candieResourceId;

    /*CONSTRUCTOR*/
    public Candie(String candieID, float candieDimension, float speed, float horizontalLocation, float verticalLocation) {
        this.candieDimension = candieDimension;
        this.speed = speed;
        this.horizontalLocation = horizontalLocation;
        this.verticalLocation = verticalLocation;
    }

    public Candie(int candieResourceId, int candieDifficulty) {
        this.candieResourceId = candieResourceId;
        this.candieDifficulty = candieDifficulty;
    }

    public Candie() {

    }

    /*GETTERS AND SETTERS*/


    public int getCandieResourceId() {
        return candieResourceId;
    }

    public void setCandieResourceId(int candieResourceId) {
        this.candieResourceId = candieResourceId;
    }

    public int getCandieDifficulty() {
        return candieDifficulty;
    }

    public void setCandieDifficulty(int candieDifficulty) {
        this.candieDifficulty = candieDifficulty;
    }

    public ImageView getCandieImage() {
        return candieImage;
    }

    public void setCandieImage(ImageView candieImage) {
        this.candieImage = candieImage;
    }

    public float getCandieDimension() {
        return candieDimension;
    }

    public void setCandieDimension(float candieDimension) {
        this.candieDimension = candieDimension;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getHorizontalLocation() {
        return horizontalLocation;
    }

    public void setHorizontalLocation(float horizontalLocation) {
        this.horizontalLocation = horizontalLocation;
    }

    public float getVerticalLocation() {
        return verticalLocation;
    }

    public void setVerticalLocation(float verticalLocation) {
        this.verticalLocation = verticalLocation;
    }


}
