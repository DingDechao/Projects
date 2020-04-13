package com.ddc.projects.java8.array;

import com.ddc.projects.java8.entity.Person;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args){
        Person[] arrayPerson = new Person[3];
        arrayPerson[0] = new Person("name1",28);
        arrayPerson[1] = new Person("name2",22);
        arrayPerson[2] = new Person("name3",25);

        Arrays.sort(arrayPerson);
        for(Person p : arrayPerson){
            System.out.println(p.getName()+"   "+p.getAge());
        }
    }
}