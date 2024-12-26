package com.ddc.projects.java11.basic;

import com.ddc.projects.java11.thread.CopyThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class CopyMain {

    public static void main(String[] args) {
        try {
//			RandomAccessFile raffrom=new RandomAccessFile("D:\\kankan\\001.xv","r");
            RandomAccessFile raffrom1 = new RandomAccessFile("D:\\kankan\\001.xv", "r");
            RandomAccessFile raffrom2 = new RandomAccessFile("D:\\kankan\\001.xv", "r");
            RandomAccessFile raffrom3 = new RandomAccessFile("D:\\kankan\\001.xv", "r");
            RandomAccessFile raffrom4 = new RandomAccessFile("D:\\kankan\\001.xv", "r");
//			RandomAccessFile rafto=new RandomAccessFile("E:/001.xv","rw");
            RandomAccessFile rafto1 = new RandomAccessFile("E:/001.xv", "rw");
            RandomAccessFile rafto2 = new RandomAccessFile("E:/001.xv", "rw");
            RandomAccessFile rafto3 = new RandomAccessFile("E:/001.xv", "rw");
            RandomAccessFile rafto4 = new RandomAccessFile("E:/001.xv", "rw");

//			long total=new File("D:\\kankan\\001.xv").length();
            long total = new File("D:\\kankan\\001.xv").length();
            System.out.println("总文件大小：" + total);

            long length1 = total / 4;
            long length2 = total / 4;
            long length3 = total / 4;
            long length4 = total - length1 - length2 - length3;

            long beginindex1 = 0;
            long beginindex2 = length1;
            long beginindex3 = length1 + length2;
            long beginindex4 = length1 + length2 + length3;

            CopyThread ct1 = new CopyThread(length1, 0, raffrom1, rafto1, beginindex1);
            CopyThread ct2 = new CopyThread(length2, 0, raffrom2, rafto2, beginindex2);
            CopyThread ct3 = new CopyThread(length3, 0, raffrom3, rafto3, beginindex3);
            CopyThread ct4 = new CopyThread(length4, 0, raffrom4, rafto4, beginindex4);

            ct1.start();
//			Thread.sleep(20);
            ct2.start();
//			Thread.sleep(20);
            ct3.start();
//			Thread.sleep(20);
            ct4.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

