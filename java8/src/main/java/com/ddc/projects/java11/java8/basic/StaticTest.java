package com.ddc.projects.java11.java8.basic;

public class StaticTest {
    public static void main(String[] args) {

        StaticDemo.name = "张三";
        StaticTest3 t3 = new StaticTest3();
        t3.print();

        StaticTest2 t2 = new StaticTest2();
        t2.print();
    }

}
