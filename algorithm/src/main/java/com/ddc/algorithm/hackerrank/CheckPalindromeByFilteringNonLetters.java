package com.ddc.algorithm.hackerrank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/check-palindrome-filter-non-letters/problem?isFullScreen=true
public class CheckPalindromeByFilteringNonLetters {
    /*
     * Complete the 'isAlphabeticPalindrome' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts STRING code as parameter.
     */

    public static boolean isAlphabeticPalindrome(String code) {
        // Write your code here
        if (code == null || code.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = code.length() - 1;
        while (left < right) {
            char leftChar = code.charAt(left);
            char rightChar = code.charAt(right);
            if (!Character.isLetter(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetter(rightChar)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = false;
        while (true) {
            String code = bufferedReader.readLine();
            result = CheckPalindromeByFilteringNonLetters.isAlphabeticPalindrome(code);
            System.out.println(result ? 1 : 0);
            if (code == null || code.isEmpty()) {
                break;
            }
        }
        bufferedReader.close();
    }
}
