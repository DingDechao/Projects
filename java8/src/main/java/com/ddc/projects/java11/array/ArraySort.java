package com.ddc.projects.java11.array;

import com.ddc.projects.java11.entity.Person;

import java.util.Arrays;

public class ArraySort {

    public void arraySortObject() {
        System.out.println("This is method arraySortObject");
        Person[] arrayPerson = new Person[3];
        arrayPerson[0] = new Person("name1", 28);
        arrayPerson[1] = new Person("name2", 22);
        arrayPerson[2] = new Person("name3", 25);

        Arrays.sort(arrayPerson);
        for (Person p : arrayPerson) {
            System.out.println(p.getName() + "   " + p.getAge());
        }
    }

    public void arraySortNumber() {
        System.out.println("This is method arraySortNumber");
        int[] a = {12, 3, 19, 2, 10, 13, 9};
        System.out.println("Before Sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]=" + a[i] + "    ");
        }
        System.out.println("");
        Arrays.sort(a);
        System.out.println("After Sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]=" + a[i] + "    ");
        }
    }

    public static void main(String[] args) {
       ArraySort arraySort = new ArraySort();
       arraySort.arraySortObject();
       arraySort.arraySortNumber();
    }
}