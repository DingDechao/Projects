package com.ddc.projects.java8.basic;

public class Rhombus {
    public static void show(int a) {
        for (int i = 1; i <= a / 2 + 1; i++) {
            for (int j = i; j <= a / 2; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i <= a / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j <= a - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        int number = 9;
        show(number);
    }
}

