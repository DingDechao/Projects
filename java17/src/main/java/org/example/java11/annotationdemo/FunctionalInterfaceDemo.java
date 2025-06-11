package org.example.java11.annotationdemo;

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
