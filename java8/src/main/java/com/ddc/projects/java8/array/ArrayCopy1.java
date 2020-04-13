package com.ddc.projects.java8.array;

public class ArrayCopy1 {
    public static void main(String[] args) {
        int[] a = {12, 3, 19, 2, 10, 13, 9};
        int[] b;
        b = a;
        System.out.println("Before Modifying:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]=" + a[i] + "    ");
        }
        System.out.println("");
        b[3] = 31;
        System.out.println("After Modifying:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]=" + a[i] + "    ");
        }
    }
}