package com.ddc.projects.java11.java8.basic;

public class TestClass {
    public static void main(String[] args) {
        Calculate parent = new ChildCalculate();
        System.out.println(parent.s + "\n" +
                parent.add(1, 2) +
                "\n" + parent.minus(1, 2));
        System.out.println("______________________________________");
        ChildCalculate son = (ChildCalculate) parent;
        System.out.println(son.s + "\n" +
                son.add(1, 2) +
                "\n" + son.minus(1, 2) +
                "\n" + son.add(1.0f, 2.0f));
    }
}
