package com.ddc.projects.java8.singleton;

public class Singleton {
    /*
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
    */



    /*
    public static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    */

/*    public static Singleton INSTANCE;

    private Singleton() {}

    public synchronized static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }*/

   /* public static Singleton INSTANCE;

    private Singleton() {}

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }*/

   private static class InnerClass{
       private static Singleton INSTALCE = new Singleton();
   }

   private Singleton() {}

   public static Singleton getInstance() {
       return InnerClass.INSTALCE;
   }
}
