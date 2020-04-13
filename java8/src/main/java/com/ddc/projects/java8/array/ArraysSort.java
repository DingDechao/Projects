package com.ddc.projects.java8.array;

import java.util.Arrays;

public class ArraysSort {
    public static void main(String[] args) {
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
}