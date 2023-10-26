package com.ddc.projects.java11.array;

public class ArrayTest {

    // 1。静态经初始化
    // 2。动态初始化



    public static void main(String[] args) {

        // 1。静态经初始化
        int[] a = new int[] {1, 2, 3, 4, 5};

        int[] d = {1, 3};

        System.out.println(a);

        Object[] b = new String[]{"aaa"};

        Object[] c = new Object[]{"bbb"};

        // 2。动态初始化
        int[] e = new int[10];
        Object[] objects = new String[4];

        var names = new String[]{"aaa", "bbb"};



        int[] f = {5, 7, 10};
        var g = new int[4];
        g = f;
        System.out.println(g.length);
    }
}
