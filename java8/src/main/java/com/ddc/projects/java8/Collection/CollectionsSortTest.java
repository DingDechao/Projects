package com.ddc.projects.java8.collection;

import com.ddc.projects.java8.entity.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CollectionsSortTest {

    private static List<Person> personList = new LinkedList<>();

    static {
        personList.add(new Person("ddc1", 22));
        personList.add(new Person("ddc2", 12));
    }

    public static void main(String[] args) {
        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
        personList.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(personList);
        personList.sort(Comparator.reverseOrder());
        System.out.println(personList);
        Collections.shuffle(personList);
    }
}
