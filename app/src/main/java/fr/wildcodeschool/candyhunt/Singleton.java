package fr.wildcodeschool.candyhunt;


import java.lang.reflect.Field;
import java.util.ArrayList;

class Singleton {

    private static final Singleton ourInstance = new Singleton();
    private final static int NBCANDIESLEVEL1 = 18;
    private final static int NBCANDIESLEVEL2 = 18;
    ArrayList<Player> players = new ArrayList();
    private ArrayList<Candie> allCandiesStock = new ArrayList<>();
    private ArrayList<Candie> candiesLevel1 = new ArrayList<>();
    private ArrayList<Candie> candiesLevel2 = new ArrayList<>();
    private int index;
    private int indexList;

    private Singleton() {
    }

    static Singleton getInstance() {
        return ourInstance;
    }

    /*Getters and Setters*/

    public int getIndexList() {
        return indexList;
    }

    public void setIndexList(int indexList) {
        this.indexList = indexList;
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


}
