package com.ddc.projects.java8.basic;

public class Pig {
    private static Pig pig;

    private Pig() {
    }

    public static Pig getPig() {
        if (pig == null) {
            pig = new Pig();
        }
        return pig;
    }

    public static void main(String[] args) {
    }
}
