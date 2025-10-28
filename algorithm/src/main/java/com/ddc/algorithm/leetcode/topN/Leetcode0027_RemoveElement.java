package com.ddc.algorithm.leetcode.topN;


import java.util.Arrays;

// 27. https://leetcode.com/problems/remove-element/description/
public class Leetcode0027_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int sum = 0;
        int index = 0;
        int[] help = new int[51];
        for (int num : nums) {
            help[num]++;
        }
        for (int i = 0; i < help.length; i++) {
            if (i != val) {
                sum += help[i];
                for (int j = 1; j <= help[i]; j++) {
                    nums[index++] = i;
                }
            }
        }
        nums = Arrays.copyOf(nums, sum);
        return sum;
    }

    public static void main(String[] args) {
        Leetcode0027_RemoveElement leetcode0027RemoveElement = new Leetcode0027_RemoveElement();
        System.out.println(leetcode0027RemoveElement.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//        System.out.println(removeElement.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
