package org.example.java11.entity;

public class Person22 implements Comparable<Person22> {
    private String name;
    private int age;


    public Person22(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Person22 o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "name = " + name + " age = " + age;
    }
}
