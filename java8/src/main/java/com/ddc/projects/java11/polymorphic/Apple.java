package com.ddc.projects.java11.polymorphic;

public class Apple extends Fruit {

    public String name = "Apple";

    public void test () {
        System.out.println("This is Apple's test method");
    }

    public static void main(String[] args) {
//        Fruit fruit = new Apple();
//        System.out.println(fruit.name);
//        fruit.test();

        Apple apple = new Apple();

        Fruit fruit = new Fruit();

    }
}
