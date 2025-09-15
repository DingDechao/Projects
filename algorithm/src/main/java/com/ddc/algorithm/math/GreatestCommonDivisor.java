package com.ddc.algorithm.math;

public class GreatestCommonDivisor {

    // 辗转相除法
    // 时间复杂度O(log(max(a,b)))
    // 例如: 15,6
    // 15 % 6 = 3
    // 6 % 3 = 0
    // 所以最大公约数是3
    // 例如: 100,80
    // 100 % 80 = 20
    // 80 % 20 = 0
    // 所以最大公约数是20
    // 例如: 7,3
    // 7 % 3 = 1
    // 3 % 1 = 0
    // 所以最大公约数是1
    public int gcd(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return gcd(big % small, small);
    }

    // 更相减损术
    // 时间复杂度O(max(a,b))
    // 例如: 15,6
    // 15 - 6 = 9
    // 9 - 6 = 3
    // 6 - 3 = 3
    // 3 - 3 = 0
    // 所以最大公约数是3
    public int gcd2(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big == small) {
            return big;
        }
        return gcd2(big - small, small);
    }

    // 更相减损术的优化版, 使用位运算
    // 时间复杂度O(log(max(a,b)))
    // 例如: 15,6
    // 15 - 6 = 9
    // 9 - 6 = 3
    // 6 - 3 = 3
    // 3 - 3 = 0
    // 所以最大公约数是3
    public int gcd3(int a, int b) {
        if (a == b) {
            return a;
        }

        if ( (a & 1) == 0 && (b & 1) == 0) {
            return gcd3(a >> 1, b >> 1) << 1;
        } else if ( (a & 1) == 0 && (b & 1) == 1) {
            return gcd3(a >> 1, b);
        } else if ( (a & 1) == 1 && (b & 1) == 0) {
            return gcd3(a, b >> 1);
        } else {
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            return gcd3(big - small, small);
        }
    }


    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcd(15, 6));
        System.out.println(gcd.gcd(100, 80));
        System.out.println(gcd.gcd(7, 3));

        System.out.println(gcd.gcd2(15, 6));
        System.out.println(gcd.gcd2(100, 80));
        System.out.println(gcd.gcd2(7, 3));

        System.out.println(gcd.gcd3(15, 6));
        System.out.println(gcd.gcd3(100, 80));
        System.out.println(gcd.gcd3(7, 3));
    }


}
