package com.ddc.projects.java11.java8.array;

public class ArrayCopy {

    public void copyArrayByEqual() {
        System.out.println("This is method copyArrayByEqual");
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
        System.out.println();
    }

    public void copyArrayBySystemCopy() {
        System.out.println("This is method copyArrayBySystemCopy");
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

    public static void main(String[] args) {
        ArrayCopy arrayCopy = new ArrayCopy();
        arrayCopy.copyArrayByEqual();
        arrayCopy.copyArrayBySystemCopy();
    }
}