package com.ddc.projects.java11.basic;

public class StaticTest2 {
    public void print() {
        String n = StaticDemo.name;
        System.out.println(n);
    }

    public static void main(String[] args) {
        StaticTest2 t2 = new StaticTest2();
        t2.print();
    }
}
