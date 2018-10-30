package fr.wildcodeschool.candyhunt;

class                                                    Singleton {
    private static final Singleton ourInstance = new Singleton();

    static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
