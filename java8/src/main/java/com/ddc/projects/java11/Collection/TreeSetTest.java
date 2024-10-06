package com.ddc.projects.java11.Collection;

import com.ddc.projects.java11.entity.Person;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Person> sortedSet = new TreeSet<>();
        sortedSet.add(new Person("ddc1", 25));
        sortedSet.add(new Person("ddc2", 28));
        sortedSet.add(new Person("ddc3", 20));

        System.out.println(sortedSet);
        NavigableSet<Person> navigableSet = new TreeSet<>(
                Comparator.comparing(Person::getName)
        );
        navigableSet.addAll(sortedSet);
        System.out.println(navigableSet);
    }
}
