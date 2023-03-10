package com.ddc.projects.java11.java8.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThreadTest {

    public static void main(String[] args) {
        try {
            String src = "D:/haha.txt";
            String dest = "C:/hehe.txt";
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            //启动四个线程来完成同一个文件的拷贝
            MyThread02 t1 = new MyThread02(fis, fos);
            MyThread02 t2 = new MyThread02(fis, fos);
            MyThread02 t3 = new MyThread02(fis, fos);
            MyThread02 t4 = new MyThread02(fis, fos);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
