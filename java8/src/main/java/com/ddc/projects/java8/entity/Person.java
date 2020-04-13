package com.ddc.projects.java8.entity;

public class Person implements Comparable<Person>{
    private String name;
    private int age;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString(){
        return "name = " + name + " age = " +age;
    }
}
