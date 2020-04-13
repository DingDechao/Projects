package com.ddc.projects.java8.array;

public class ArrayCopy2 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];
        System.out.println("Before Copying:");
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
            b[i] = (i + 1) * 100;
            System.out.print("b[" + i + "]=" + b[i] + "    ");
        }
        System.out.println("");
        System.arraycopy(a, 2, b, 5, 5);
        System.out.println("After Copying:");
        for (int i = 0; i < b.length; i++) {
            System.out.print("b[" + i + "]=" + b[i] + "    ");
        }
    }
}