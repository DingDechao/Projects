package com.ddc.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IsThereACycle {
    // 判断链表是否有环

    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    // 可以用hash表记录每次便利的节点,如果遍历的节点已经存在于hash表中,则说明有环
    // 不是最佳方法
    // 时间复杂度O(N),空间复杂度O(N)
     public boolean hasCycle1(ListNode head) {
         if (head == null || head.next == null) {
             return false;
         }
         Set<ListNode> set = new HashSet<>();
         ListNode current = head;
         while (current != null) {
             if (set.contains(current)) {
                 return true;
             }
             set.add(current);
             current = current.next;
         }
         return false;
     }


    // 快慢指针, 实际上是追及问题
    // 慢指针每次走一步,快指针每次走两步,如果有环,快指针一定会追上慢指针
    // 这个是最佳方法
    // 时间复杂度O(N),空间复杂度O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        IsThereACycle isThereACycle = new IsThereACycle();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node3; // 形成环

        System.out.println(isThereACycle.hasCycle(node1)); // false

        node5.next = node2; // 形成环
        System.out.println(isThereACycle.hasCycle(node1)); // true
    }

}
