package org.example.java11.basic;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateformateDemo {

    public static void main(String[] args) {
        Date date = new Date();
        /* DateFormat.FUll      0
         * DateFormat.DEFAULT   默认的
         * DateFormat.LONG      1
         * DateFormat.MEDIUM    2
         * DateFormat.SHORT     3
         *
         */
//		DateFormat df=DateFormat.getDateInstance(0);
//		String s=df.format(date);
//		System.out.println(s);

        /* DateFormat.FUll      0
         * DateFormat.DEFAULT   默认的
         * DateFormat.LONG      1
         * DateFormat.MEDIUM    2
         * DateFormat.SHORT     3
         *
         */
//		DateFormat df3=DateFormat.getTimeInstance(DateFormat.SHORT);
//		String s3=df3.format(date);
//		System.out.println(s3);
        DateFormat df2 = DateFormat.getDateTimeInstance(3, 1);
        String s2 = df2.format(date);
        System.out.println(s2);
    }
}
