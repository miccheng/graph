package com.example.leetcode.tree;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaxPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left =Math.max(0, postOrder(root.left));//bound it to 0 if it is negative
        int right =Math.max(0, postOrder(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}