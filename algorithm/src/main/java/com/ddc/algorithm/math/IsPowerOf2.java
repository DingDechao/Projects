package com.ddc.algorithm.math;

public class IsPowerOf2 {

    // 暴力方法1
    public boolean isPowerOf21(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    // 暴力方法2
    public boolean isPowerOf22(int n) {
        if (n < 1) {
            return false;
        }

        int temp = 1;
        while (temp <= n) {
            if(temp == n) {
                return true;
            }
            temp = temp << 1;

        }
        return false;
    }

    // 最好的方法： 位运算
    // O(1)
    public boolean isPowerOf2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOf2 isPowerOf2 = new IsPowerOf2();
        System.out.println(isPowerOf2.isPowerOf21(16));
        System.out.println(isPowerOf2.isPowerOf21(15));
        System.out.println(isPowerOf2.isPowerOf21(1));
        System.out.println(isPowerOf2.isPowerOf21(0));
        System.out.println(isPowerOf2.isPowerOf21(-16));

        System.out.println("========");

        System.out.println(isPowerOf2.isPowerOf22(16));
        System.out.println(isPowerOf2.isPowerOf22(15));
        System.out.println(isPowerOf2.isPowerOf22(1));
        System.out.println(isPowerOf2.isPowerOf22(0));
        System.out.println(isPowerOf2.isPowerOf22(-16));

        System.out.println("========");

        System.out.println(isPowerOf2.isPowerOf2(16));
        System.out.println(isPowerOf2.isPowerOf2(15));
        System.out.println(isPowerOf2.isPowerOf2(1));
        System.out.println(isPowerOf2.isPowerOf2(0));
        System.out.println(isPowerOf2.isPowerOf2(-16));
    }

}
