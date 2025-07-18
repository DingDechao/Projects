package com.ddc.algorithm.bitoperation;

public class NumberOf1Bits {

    //https://leetcode.cn/problems/number-of-1-bits/
    public int hammingWeight(int n) {
        int count = 0;
        for (var i=31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
