package com.ddc.algorithm.leetcode.topN;

// 9. https://leetcode.com/problems/palindrome-number/description/
public class Leetcode0009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }
}
