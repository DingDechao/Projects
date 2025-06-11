package org.example.java11.Collection;

import org.example.java11.entity.Person22;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CollectionsSortTest {

    private static List<Person22> personList = new LinkedList<>();

    static {
        personList.add(new Person22("ddc1", 22));
        personList.add(new Person22("ddc2", 12));
    }

    public static void main(String[] args) {
        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
        personList.sort(Comparator.comparingInt(Person22::getAge).reversed());
        System.out.println(personList);
        personList.sort(Comparator.reverseOrder());
        System.out.println(personList);
        Collections.shuffle(personList);
    }
}
