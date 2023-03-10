package com.ddc.projects.java11.java8.thread;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SendCode implements Runnable {
    //号码
    int code = 0;

    RandomAccessFile raf = null;

    //初始化块
    {
        try {
            raf = new RandomAccessFile("sendCode.txt", "rw");
            code = raf.readInt();
            System.out.println("恢复上次记录：" + code);
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到！");
        } catch (IOException e) {
            System.out.println("没有合适的整数值");
        }
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                code++;
                try {
                    raf.seek(0);//从文件开头以字节为单位测量的偏移量位置，在该位置设置文件指针
                    raf.writeInt(code);//从文件指针的当前位置开始写
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "申请到号码：" + code);
            }
        }
    }

    public static void main(String[] args) {
        //初始化块只会在对象创建过程中执行一次，即new一次执行一次。我们共享资源，所有线程刚好公用一个sc对象，
        //所以把我们读取上一次记录的,操作放在里面进行。
        SendCode sc = new SendCode();
        new Thread(sc, "一号线程").start();
        new Thread(sc, "二号线程").start();
        new Thread(sc, "三号线程").start();
        new Thread(sc, "四号线程").start();
    }
}

