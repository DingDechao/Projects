package com.ddc.algorithm.tree;

public class IsBalanceBinaryTree {

    public static class TreeNode<T> {
        T value;
        IsBalanceBinaryTree.TreeNode<T> left;
        IsBalanceBinaryTree.TreeNode<T> right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info process(TreeNode<Integer> treeNode) {
        if (treeNode == null ) {
            return new Info(true, 0);
        }
        Info leftInfo = process(treeNode.left);
        Info rightInfo = process(treeNode.right);
        boolean isBalanced = true;
        if (!leftInfo.isBalanced) {
            isBalanced = false;
        }
        if(!rightInfo.isBalanced) {
            isBalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, Math.max(leftInfo.height, rightInfo.height) + 1);
    }
}
