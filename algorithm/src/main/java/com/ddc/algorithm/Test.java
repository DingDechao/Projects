package com.ddc.algorithm;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hammingWeight(11);
    }
}

class Solution {
    public int hammingWeight(int n) {
       int[] arr = new int[32];
        for (var i=31; i >= 0; i--) {
           arr[i] = (n >> i) & 1;
        }
        int count = 0;
        for (int s : arr) {
            if (s == 1) {
                count++;
            }
        }
        return count;
    }
}
