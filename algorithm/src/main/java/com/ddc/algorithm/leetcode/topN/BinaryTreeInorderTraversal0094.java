package com.ddc.algorithm.leetcode.topN;

import java.util.ArrayList;
import java.util.List;

// 94 : https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class BinaryTreeInorderTraversal0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        process(root, list);
        return list;

    }

    public void process(TreeNode node, List<Integer> list) {
        if (node == null) return;
        process(node.left, list);
        list.add(node.val);
        process(node.right, list);
    }
}
