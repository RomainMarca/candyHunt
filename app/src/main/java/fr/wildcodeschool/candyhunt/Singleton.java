package fr.wildcodeschool.candyhunt;

import android.widget.ImageView;

import java.util.ArrayList;

class Singleton {

    private static final Singleton ourInstance = new Singleton();

    private ArrayList<Candie> allCandiesStock = new ArrayList<>();
    private ArrayList<Candie> candiesLevel1 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel2 = new ArrayList<>();


    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    /*public void initCandiesByLevel(int candiesLevel) {
        int candieIndex = 1;
        boolean hasOtherCandieLeft = true;
        ArrayList<Candie> newCandiesList = new ArrayList<>();

        while(hasOtherCandieLeft) {
            ImageView candieImage;
            String candieFileName = "g"+candiesLevel+"c"+candieIndex;
            int identifier3 = .getResources().getIdentifier(pictos2, "drawable", getPackageName());
            candieImage.setImageResource(R.drawable.);
            Candie newCandie = new Candie();
            newCandie.setCandieImage();

        }

    }*/
}
