package com.ddc.projects.java11.stackandheap;

public class StackAndHeapTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "name1";
        person1.age = 10;

        Person person2 = new Person();
        person2.name = "name2";
        person2.age = 20;

        Person[] peopleArray = {person1, person1};
        person1.age = 100;
        System.out.println(peopleArray[0].age);
    }
}

class Person {
    String name;
    int age;
}
