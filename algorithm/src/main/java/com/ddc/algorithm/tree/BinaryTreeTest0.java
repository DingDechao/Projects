package com.ddc.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


    public void preOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.value);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);

    }
    public void middleOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }

        middleOrderTraversal(treeNode.left);
        System.out.println(treeNode.value);
        middleOrderTraversal(treeNode.right);

    }

    public void postOrderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.println(treeNode.value);

    }

    public void preOrderTraversalWithStack(TreeNode<Integer> treeNode) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }


            if(!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }

        }
    }

    public void levelOrderTraversal(TreeNode<Integer> treeNode) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode<Integer> treeNode1 = queue.poll();
            System.out.println(treeNode1.value);
            if(treeNode1.left != null) {
                queue.offer(treeNode1.left);
            }

            if(treeNode1.right !=null) {
                queue.offer(treeNode1.right);
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
         BinaryTreeTest0 binaryTreeTest0 = new BinaryTreeTest0();
        TreeNode<Integer> treeNode = binaryTreeTest0.generateTreeNode(linkedList);
        System.out.println("=============");
        binaryTreeTest0.preOrderTraversal(treeNode);
        System.out.println("=============");
        binaryTreeTest0.middleOrderTraversal(treeNode);
        System.out.println("=============");
        binaryTreeTest0.postOrderTraversal(treeNode);
        System.out.println("=============");
        binaryTreeTest0.levelOrderTraversal(treeNode);

    }


}
