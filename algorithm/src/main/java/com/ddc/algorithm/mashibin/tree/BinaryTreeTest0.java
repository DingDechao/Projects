package com.ddc.algorithm.mashibin.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeTest0 {

    public static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    public TreeNode<Integer> generateTreeNode(LinkedList<Integer> linkedList) {
        TreeNode<Integer> treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }

        Integer element = linkedList.removeFirst();
        if (element !=null ) {
            treeNode = new TreeNode<>(element);
            treeNode.left = generateTreeNode(linkedList);
            treeNode.right = generateTreeNode(linkedList);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 4, 5, 9, null, null, null, null));
        TreeNode<Integer> treeNode = new BinaryTreeTest0().generateTreeNode(linkedList);
        System.out.println("=============");
    }
}
