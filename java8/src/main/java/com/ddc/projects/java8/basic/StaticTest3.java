package com.ddc.projects.java8.basic;

public class StaticTest3 {
    public void print() {
        StaticDemo.name = "wahaha";
        String n = StaticDemo.name;
        System.out.println(n);
    }
}
