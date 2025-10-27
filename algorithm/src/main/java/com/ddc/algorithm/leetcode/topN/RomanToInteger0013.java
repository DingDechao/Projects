package com.ddc.algorithm.leetcode.topN;


import java.util.HashMap;
import java.util.Map;

//13. https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger0013 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        RomanToInteger0013 romanToInteger = new RomanToInteger0013();
        String s = "MCMXCIV";
        int result = romanToInteger.romanToInt(s);
        System.out.println("Roman numeral: " + s + " => Integer: " + result);
    }
}
