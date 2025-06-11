package org.example.java11.array;

import org.example.java11.entity.Person22;

import java.util.Arrays;

public class ArraySort {

    public void arraySortObject() {
        System.out.println("This is method arraySortObject");
        Person22[] arrayPerson = new Person22[3];
        arrayPerson[0] = new Person22("name1", 28);
        arrayPerson[1] = new Person22("name2", 22);
        arrayPerson[2] = new Person22("name3", 25);

        Arrays.sort(arrayPerson);
        for (Person22 p : arrayPerson) {
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