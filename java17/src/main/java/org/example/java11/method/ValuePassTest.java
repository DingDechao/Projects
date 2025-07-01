package org.example.java11.method;


public class ValuePassTest {

    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a);
        System.out.println(b);
    }

    public void swap(Person p) {
        int tmp = p.name;
        p.name = p.age;
        p.age = tmp;
        System.out.println(p.name);
        System.out.println(p.age);
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        ValuePassTest valuePassTest = new ValuePassTest();
        valuePassTest.swap(a, b);
        System.out.println(a);
        System.out.println(b);

        Person p = new Person();
        p.name = 20;
        p.age = 10;

        valuePassTest.swap(p);
        System.out.println(p.name);
        System.out.println(p.age);
    }
}
class Person {
    int name;
    int age;
}