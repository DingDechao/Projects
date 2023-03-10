package com.ddc.projects.java11.java8.basic;

public class P06 {
    public static void main(String[] args) {
        int[] arr = new int[300];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int k = 0;
        for (int j = 0; j < 300; j++) {
            if ((j + 1) % 3 == 0) {
                arr[j] = 0;
            }
            if (arr[j] != 0) {
                arr[k + 100] = arr[j];
                k++;
            }
        }
        for (int s = 0; s < 300; s++) {
            System.out.print(arr[s] + "(" + (s + 1) + ")" + "\t");
        }
        System.out.println();
        System.out.println(arr[298] - 1);
    }
}
