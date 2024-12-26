package com.ddc.projects.java11.basic;

public class TestPig {
    public void char01(String ss, int m) {
        byte[] b = ss.getBytes();
        char[] a = ss.toCharArray();
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (b[i] < 0) {
                count++;
            }
        }
//		System.out.println(count+"/"+b[m-1]+"/"+count/2);
        if (count % 2 == 0 && b[m - 1] < 0 && count / 2.0 <= 0) {
            for (int i = 0; i < m - 1; i++) {
                System.out.print(a[i]);
            }
        } else if (count % 2 != 0 && b[m - 1] < 0 && count / 2.0 <= 0) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
            }
        } else if (count % 2 != 0 && b[m - 1] < 0 && (count / 2) > 0) {
            for (int i = 0; i < m - count / 2.0; i++) {
                System.out.print(a[i]);
            }
        } else if (count % 2 == 0 && b[m - 1] < 0 && count / 2.0 > 0) {
            for (int i = 0; i < m - count / 2.0; i++) {
                System.out.print(a[i]);
            }
        } else {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        String ss = "jafdfsdfsdfsfdsfva程序教程";
        TestPig t = new TestPig();
        t.char01(ss, 19);
        //壹 贰 叁 肆 伍 陆 柒 捌 玖 拾
    }
}
