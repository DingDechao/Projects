package com.ddc.algorithm.topN;


import java.util.HashMap;
import java.util.Map;

//1. https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                return new int[]{i, map.get(rest)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
