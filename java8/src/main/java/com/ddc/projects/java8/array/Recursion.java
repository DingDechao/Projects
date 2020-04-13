package com.ddc.projects.java8.array;

public class Recursion {
    /**
     * 递归：自己调用自己
     * 5! = 5*4!
     * 4!=4*3!
     * n!   n==1   n=1
     * n!=n*(n-1)!
     *
     * @param args
     */
    //如果我们定义getN（）就是表示一个数的阶乘
    public int getN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getN(n - 1);
        }
    }

    public static void main(String[] args) {
        Recursion ss = new Recursion();
        int a = ss.getN(5);
        System.out.println(a);
    }
}
