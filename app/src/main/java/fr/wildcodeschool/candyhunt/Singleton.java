package fr.wildcodeschool.candyhunt;

import android.content.Context;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

class Singleton {

    private static final Singleton ourInstance = new Singleton();

    private ArrayList<Candie> allCandiesStock = new ArrayList<>();
    private ArrayList<Candie> candiesLevel1 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel2 = new ArrayList<>();
    private final static int NBCANDIESLEVEL1 = 18;
    private final static int NBCANDIESLEVEL2 = 18;

    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }

    public void initCandies() {

        String resourceName;
        int IdToSet;

        for(int i = 1; i <= NBCANDIESLEVEL1 ; i++) {
            resourceName = "G"+1+"C"+i;
            IdToSet = getId(resourceName, R.drawable.class);
            candiesLevel1.add(new Candie(IdToSet, 1));
            resourceName = "G"+2+"C"+i;
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
}
