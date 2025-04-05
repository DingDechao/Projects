package com.ddc.projects.java11.polymorphic;

public class Fruit {

    public String name = "Fruit";
    private static int a = 0;

    static {
        a = 6;
    }

    public Fruit() {
       // test();
        System.out.println(a);
    }

    public void test () {
        System.out.println("This is Fruit's test method");
    }
}
