package com.ddc.algorithm.leetcode.topN;

// 14. https://leetcode.com/problems/longest-common-prefix/
public class Leetcode0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                return "";
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        if (minLen == 0) {
            return "";
        }

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        Leetcode0014_LongestCommonPrefix leetcode0014LongestCommonPrefix = new Leetcode0014_LongestCommonPrefix();
//        String[] strs = {"f", "c", "flight"};
        String[] strs = {"flower", "flow", "flight"};
        String result = leetcode0014LongestCommonPrefix.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
    }
}
