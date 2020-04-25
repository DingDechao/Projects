package com.ddc.projects.java8.basic;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemmo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
//		date.getSeconds();
////		Date date1=new java.sql.Date(1212121212L);
        //2012年09月18日 10:20:33 星期二
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        String s = sdf.format(date);
//		System.out.println(s);
        //date==>>String
        //String ==>>date
        //2012-09-18 11:11:11
        String dt = "2001-07-04T12:08:56.235-0700 ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try {
            Date dd = sdf2.parse(dt);
            System.out.println(dd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//		File file=new File("E:/test.txt");

//		long start=file.lastModified();
//		while(true){
//			long end=file.lastModified();
//			System.out.println(end);
//			if(start!=end){
//				System.out.println("文件被修改了！");
//				break;
//			}
//
//		}

//		java.sql.Date date1 = (java.sql.Date) new java.util.Date();
//		java.util.Date date2 = new java.sql.Date(6666l);
    }
}

