package fr.wildcodeschool.candyhunt;

import java.util.ArrayList;

class Singleton {

    private static final Singleton ourInstance = new Singleton();

    private ArrayList<Candie> allCandiesStock = new ArrayList<>();
    private ArrayList<Candie> candiesLevel1 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel2 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel3 = new ArrayList<>();


    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public void initCandies() {
        int candieIndex = 1;
        boolean anotherCandieExist = true;
        while(anotherCandieExist) {



        }


    }
}
