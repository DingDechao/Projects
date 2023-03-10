package com.ddc.projects.java11.java8.basic;

public class P04 {
    public static void main(String[] args) {
        int[][] arr1 = {{10, 20, 30, 40}, {05, 0, 1, 0}, {39, 40, 56, 78}, {34, 90, 1, 1}};
        int[][] arr2 = {{18, 29, 30, 40}, {1, 0, 1, 0}, {0, 40, 56, 78}, {7, 90, 1, 1}};
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[i][j] + arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
