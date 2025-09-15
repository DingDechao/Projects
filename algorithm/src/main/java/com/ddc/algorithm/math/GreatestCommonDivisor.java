package com.ddc.algorithm.math;

public class GreatestCommonDivisor {

    public int gcd(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        if (small == 1) {
            return 1;
        }
        return gcd(big % small, small);
    }


    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcd(15, 6));
        System.out.println(gcd.gcd(100, 80));
        System.out.println(gcd.gcd(7, 3));
    }


}
