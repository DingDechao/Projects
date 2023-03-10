package com.ddc.projects.java11.java8.basic;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarShow {
    public static int getDayNum(int moth, int year) {
        int num = 0;
        if (moth == 3 || moth == 5 || moth == 8 || moth == 10) {
            num = 30;
        } else if (moth == 1) {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                num = 29;
            } else {
                num = 28;
            }
        } else if (moth < 0 || moth > 12) {
            System.out.println("你确定有这么个月？");
        } else {
            num = 31;
        }
        return num;
    }

    //4 6 9 11
    //1 3 5 7 8 10 12
    public static void main(String[] args) {
        int year = 0;
        int moth = 0;
        int maxday = 0;
        Calendar cd = Calendar.getInstance();
        System.out.println("请输入年份：");
        Scanner sc = new Scanner(System.in);
        year = Integer.parseInt(sc.nextLine());
        System.out.println("请输入月份：");
        moth = Integer.parseInt(sc.nextLine());
        maxday = getDayNum(moth, year);
        cd.set(Calendar.YEAR, year);
        cd.set(Calendar.MONTH, moth);
        cd.set(Calendar.DAY_OF_MONTH, 1);
        int weekstart = cd.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int j = 0; j < weekstart; j++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= maxday; i++) {
            int day = cd.get(Calendar.DAY_OF_MONTH);
            int week = cd.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.print(day + "\t");
            if (week == 6) {
                System.out.println();
            }
            cd.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}

