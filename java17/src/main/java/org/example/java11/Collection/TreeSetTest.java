package org.example.java11.Collection;

import org.example.java11.entity.Person22;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Person22> sortedSet = new TreeSet<>();
        sortedSet.add(new Person22("ddc1", 25));
        sortedSet.add(new Person22("ddc2", 28));
        sortedSet.add(new Person22("ddc3", 20));

        System.out.println(sortedSet);
        NavigableSet<Person22> navigableSet = new TreeSet<>(
                Comparator.comparing(Person22::getName)
        );
        navigableSet.addAll(sortedSet);
        System.out.println(navigableSet);
    }
}
