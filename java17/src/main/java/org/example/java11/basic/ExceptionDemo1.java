package org.example.java11.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo1 {
    {
    }

    //
    static {
    }

    public static void exceptionDemo() {
        String s = null;
        System.out.println(s.toString());
    }

    public static void exceptionDemo2() {
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }

    public static void exceptionDemo3() {
        int[] i = new int[10];
        System.out.println(i[10]);
    }

    public static void exceptionDemo4() {
        Children c = (Children) new Father();
    }

    public static void exceptionDemo5() {
        String s = "a";
        int i = Integer.parseInt(s);
    }

    // check 添加声明式异常
    // 极其不负责任的做法，向外抛出，谁调用该放，谁处理该异常
    public static void exceptionDemo6() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("c:\\wahaha.txt");
    }

    public static void exceptionDemo7() {
        // 负责任的做法，在当前方法中处理
        try {
            FileInputStream fis = new FileInputStream("c:\\www.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void exceptionDemo8() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("c:\\a.txt");
            while (fis.read() != -100) {
            }
            fis.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    // 类找不到异常
    public static void execptionDemo9() {
        String cls = "com.softee.Studnet";
        try {
            Class clz = Class.forName(cls);
            Object obj = clz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // java core
    // 如何判断一个给定的字符是否是整数 String str ="a" "1" a--z A--Z
    // Integer.parseInt(str);
    public static void isInt(String str) {
        try {
            int i = Integer.parseInt(str);
            System.out.println("是整数");
        } catch (Exception e) {
            System.out.println("不是整数");
        }
    }

    public static void main(String[] args) {
        //	exceptionDemo();
        //	exceptionDemo2();
        //	exceptionDemo3();
        //	exceptionDemo4();
        //	exceptionDemo5();
        try {
            exceptionDemo6();
        } catch (FileNotFoundException e) {
            System.out.println("活该出一场，文件没找到");
        }
        //	exceptionDemo7();
        //	exceptionDemo8();
        execptionDemo9();
    }
}

class Father {
}

class Children extends Father {
}