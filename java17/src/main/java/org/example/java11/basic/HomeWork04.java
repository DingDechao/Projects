package org.example.java11.basic;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomeWork04 {
    //	4从控制台输入数据，按如下格式保存到文件中，直到用户输入QUIT为止：
//	   【2008-10-10 23:12:10】input your name pls(模拟的数据):
//	   【2008-10-10 23:12:10】hello world:
    public static void show(FileWriter rw) {
        try {
            System.out.println("请输入：");
            Scanner sc = new Scanner(System.in);
            String sb = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
            Date date = new Date();
            String str = sdf.format(date);
            if (sb.equals("quit")) {
                System.out.println("退出");
            } else {
                String a = str + sb;
                rw.write(a + "\r\n");
                show(rw);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            FileWriter rw = new FileWriter("E:/ddc.txt");
            show(rw);
            rw.flush();
            rw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

