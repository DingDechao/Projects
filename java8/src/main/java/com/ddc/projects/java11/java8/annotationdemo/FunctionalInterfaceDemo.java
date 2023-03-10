package com.ddc.projects.java11.java8.annotationdemo;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

    static void staticMethod() {
        System.out.println("Static method");
    }

    default void defaultMethod() {
        System.out.println("Default Method");
    }

    void test();

    //void test1();
}
