package com.ddc.algorithm.lru;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    // LRU缓存机制 : Least Recently Used
    // 设计一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
    // 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    // 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「键值对」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    // 每次访问和插入数据时, 都会把该数据放到最前面
    // 当容量满了, 删除最后面的数据
    // 示例:
    // LRUCache lRUCache = new LRUCache(2); // 2 表示缓存容量
    // lRUCache.put(1, 1); // 缓存是 {1=1}
    // lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    // lRUCache.get(1);    // 返回 1
    // lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    // lRUCache.get(2);    // 返回 -1 (未找到)
    // lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    // lRUCache.get(1);    // 返回 -1 (未找到)
    // lRUCache.get(3);    // 返回 3
    // lRUCache.get(4);    // 返回 4

    private int limit;

    private Map<Integer, Node> map;
    private Node head;
    private Node end;

    public LRU(int limit) {
        this.limit = limit;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            refreshNode(node);
            return node.value;
        }
        return -1;
    }

    public void refreshNode(Node node) {
        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            refreshNode(node);
        } else {
            if (map.size() >= limit) {
                map.remove(head.key);
                removeNode(head);
            }
            node = new Node(key, value);
            addNode(node);
            map.put(key, node);
        }
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            end = node;
        } else {
            end.next = node;
            node.prev = end;
            end = node;
        }
    }

    public void removeNode(Node node) {
        if (node == null) return;
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    // 进阶: 你是否可以在 O(1) 时间复杂度内完成这两种操作？
    // 思路: 使用双向链表和哈希表实现
    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 返回 1
        lru.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lru.get(2)); // 返回 -1 (未找到)
        lru.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lru.get(1)); // 返回 -1 (未找到)
        System.out.println(lru.get(3)); // 返回 3
        System.out.println(lru.get(4)); // 返回 4
    }
}
