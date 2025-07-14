package com.ddc.algorithm.mashibin.tree;

import java.util.LinkedList;

public class IsBinarySearchTreeTest0 {

    public static class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    public BinaryTreeTest0.TreeNode<Integer> generateTreeNode(LinkedList<Integer> linkedList) {
        BinaryTreeTest0.TreeNode<Integer> treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return treeNode;
        }

        Integer element = linkedList.removeFirst();
        if (element !=null ) {
            treeNode = new BinaryTreeTest0.TreeNode<>(element);
            treeNode.left = generateTreeNode(linkedList);
            treeNode.right = generateTreeNode(linkedList);
        }
        return treeNode;
    }

    public static class Info {
        public boolean isBinarySearchTree;
        public int maxValue;
        public int minValue;

        public Info(int minValue, boolean isBinarySearchTree, int maxValue) {
            this.minValue = minValue;
            this.isBinarySearchTree = isBinarySearchTree;
            this.maxValue = maxValue;
        }
    }


    public static Info process(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        Info leftInfo = process(treeNode.left);
        Info rightInfo = process(treeNode.right);
        int maxValue;
        int minValue;
        boolean isBinarySearchTree;
        if (leftInfo == null && rightInfo == null) {
            return null;
        } else if (leftInfo != null && rightInfo == null) {
            maxValue = leftInfo.maxValue;
            minValue = leftInfo.minValue;
            isBinarySearchTree = leftInfo.isBinarySearchTree;
        } else if (leftInfo == null && rightInfo != null) {
            maxValue = rightInfo.maxValue;
            minValue = rightInfo.minValue;
            isBinarySearchTree = rightInfo.isBinarySearchTree;
        } else {
            maxValue = Math.max(leftInfo.maxValue, rightInfo.maxValue);
            minValue = Math.min(leftInfo.minValue, rightInfo.minValue);
            isBinarySearchTree = leftInfo.isBinarySearchTree && rightInfo.isBinarySearchTree;
        }
        return new Info(minValue, isBinarySearchTree, maxValue);
    }
}
