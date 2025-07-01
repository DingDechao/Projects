package org.example.java11.basic;

import java.util.Calendar;
import java.util.Scanner;

public class Yue {
    //	输入一个年份就生成12个月
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

    public static void main(String[] args) {
        int year = 0;
        int maxday = 0;
        Calendar cd = Calendar.getInstance();

        System.out.println("请输入年份：");
        Scanner sc = new Scanner(System.in);
        year = Integer.parseInt(sc.nextLine());
        cd.set(Calendar.YEAR, year);
        for (int month = 0; month <= 11; month++) {
            System.out.print("-----------------------" + (month + 1) + "月" + "------------------------");
            maxday = getDayNum(month, year);
            cd.set(Calendar.MONTH, month);
            cd.set(Calendar.DAY_OF_MONTH, 1);
            int weekstart = cd.get(Calendar.DAY_OF_WEEK) - 1;
            System.out.println();

            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for (int j = 0; j < weekstart; j++) {
                System.out.print("\t");
            }
            for (int i = 1; i <= maxday; i++) {
                int day = cd.get(Calendar.DAY_OF_MONTH);
                int week = cd.get(Calendar.DAY_OF_WEEK) - 1;
                System.out.print(i + "\t");
                if (week == 6) {
                    System.out.println();
                }
                cd.add(Calendar.DAY_OF_MONTH, 1);

            }
            System.out.println();
        }
    }
}

