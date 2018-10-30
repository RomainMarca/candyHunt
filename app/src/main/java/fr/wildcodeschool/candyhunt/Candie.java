package fr.wildcodeschool.candyhunt;

import android.widget.ImageView;

public class Candie {

    String candieID;
    //TODO Imageview direct du bonbon ? Ou bien bitmap ? A décider et à mettre en place
    float candieDimension;
    float speed;
    float horizontalLocation;
    float verticalLocation;
    int candieDifficulty;
    ImageView candieImage;

    /*CONSTRUCTOR*/
    public Candie(String candieID, float candieDimension, float speed, float horizontalLocation, float verticalLocation) {
        this.candieID = candieID;
        this.candieDimension = candieDimension;
        this.speed = speed;
        this.horizontalLocation = horizontalLocation;
        this.verticalLocation = verticalLocation;
    }

    /*GETTERS AND SETTERS*/

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

    public String getCandieID() {
        return candieID;
    }

    public void setCandieID(String candieID) {
        this.candieID = candieID;
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
