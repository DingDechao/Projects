package com.ddc.algorithm.linkedlist;

public class CycleEntryPoint {

    // 链表是不是有环, 如果有环, 求出环的入口节点
    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }



    public int cycleEntryPoint(ListNode head) {
        if (head == null || head.next == null) {
            return -1;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 找到环的入口节点
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.value;
            }
        }
        return -1;
    }

    // 快慢指针, 实际上是追及问题
    // 慢指针每次走一步,快指针每次走两步,如果有环,快指针一定会追上慢指针
    // 这个是最佳方法
    // 时间复杂度O(N),空间复杂度O(1)
    public int cycleLength1(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 有环, 计算环的长度
                int length = 1;
                ListNode current = slow.next;
                while (current != slow) {
                    length++;
                    current = current.next;
                }
                return length;
            }
        }
        return 0;
    }


    // 快慢指针, 实际上是追及问题
    // 慢指针每次走一步,快指针每次走两步,如果有环,快指针一定会追上慢指针
    // 这个是最佳方法
    // 时间复杂度O(N),空间复杂度O(1)
    public int cycleLength2(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 有环, 计算环的长度
                int length = 1;
                slow = slow.next;
                fast = fast.next.next;
                while (fast != slow) {
                    length++;
                    slow = slow.next;
                    fast = fast.next.next;
                }
                return length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CycleEntryPoint cycleEntryPoint = new CycleEntryPoint();
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

        System.out.println(cycleEntryPoint.cycleLength1(node1)); // 0

        node5.next = node2; // 形成环
        System.out.println(cycleEntryPoint.cycleLength1(node1)); // 4
        System.out.println(cycleEntryPoint.cycleLength2(node1)); // 4
        System.out.println(cycleEntryPoint.cycleEntryPoint(node1)); // 2
    }
}
