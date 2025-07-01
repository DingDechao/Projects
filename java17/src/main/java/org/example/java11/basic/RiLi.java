package org.example.java11.basic;

import java.util.Calendar;
import java.util.Scanner;

public class RiLi {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入要打印日历的年份：");
        int year = s.nextInt();
        //int month = s.nextInt();
        Practice1 reli = new Practice1();
        for (int month = 1; month < 13; month++) {
            System.out.println(month + "月的日历");
            reli.print(c, year, month);
            System.out.println();
        }
    }
}
