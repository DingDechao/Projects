package com.ddc.projects.java11.java8.basic;

import java.util.Calendar;

public class Practice1 {
    public static int mt(Calendar c, int year, int month) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, 1);
//		System.out.println(c.get(Calendar.DAY_OF_MONTH));
        int i = c.getActualMaximum(Calendar.DAY_OF_MONTH);
//		System.out.println(i);
        return i;
    }

    public static boolean compare(Calendar c1) {
        Calendar c2 = Calendar.getInstance();
        boolean b1 = c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
        boolean b2 = c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
        boolean b3 = c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
        if (b1 && b2 && b3) {
            return true;
        }
        return false;
    }

    public void print(Calendar c, int year, int month) {
        int n = mt(c, year, month);
//		System.out.println();
//		System.out.println();
        System.out.println("SUN\tMON\tTUE\tWEN\tTHU\tFRI\tSAT");
        c.set(Calendar.MONTH, month - 1);
        for (int i = 1; i <= n; i++) {
            c.set(Calendar.DAY_OF_MONTH, i);
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 1;
            //如果今天是1号
            if (i == 1) {
                System.out.println(c.get(Calendar.YEAR) + "666666666666666");
                System.out.println(c.get(Calendar.DAY_OF_MONTH) + "[[[[[[[[[[[[[[[[");
                System.out.println(weekday + "...............");
                //打印1号前面的空格
                for (int j = 0; j < weekday; j++) {
                    System.out.print("\t");
                }
            }
            if (compare(c)) {
                System.out.print("*");
            }
            System.out.print(i + "\t");
            if (weekday == 6) {
                System.out.println();
            }
        }
    }
}

