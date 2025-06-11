package org.example.java11;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("Hello world!");

    }
}



class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arrayLength = nums.length;
        Map<Integer, Integer> numberIndex = new HashMap<>(arrayLength - 1);
        numberIndex.put(nums[0], 1);
        for (int i = 1; i < arrayLength; i++ ) {
            if (numberIndex.containsKey(target - nums[i])) {
                return new int[]{numberIndex.get(target - nums[1]), i};
            }
            numberIndex.put(nums[i], i);
        }
        return new int[2];
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Solution1 {
//    public ListNode removeDuplicateNodes(ListNode head) {
//
//    }
//}


