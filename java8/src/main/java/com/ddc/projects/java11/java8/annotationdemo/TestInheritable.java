package com.ddc.projects.java11.java8.annotationdemo;

@InheritedDemo
class A {

}

public class TestInheritable extends A{
    public static void main(String[] args) {
        // true
        System.out.println(TestInheritable.class.isAnnotationPresent(InheritedDemo.class));
    }
}
