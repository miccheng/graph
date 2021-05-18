package com.example.leetcode.tree;

public class MaximumDepthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        root.left=left;
        maxDepth(root);
    }

    public static int maxDepth(TreeNode root) {
        //base
        if (root == null) return 0;

        //body
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
