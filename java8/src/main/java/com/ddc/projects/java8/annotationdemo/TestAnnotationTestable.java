package com.ddc.projects.java8.annotationdemo;

public class TestAnnotationTestable {

    public static void method1() {
        System.out.println("This is method 1");
    }

    @Testable
    public static void method2() {
        System.out.println("This is method 2");
    }

    public static void method3() {
        System.out.println("This is method 3");
    }

    @Testable
    public static void method4() {
        System.out.println("This is method 4");
    }
}
