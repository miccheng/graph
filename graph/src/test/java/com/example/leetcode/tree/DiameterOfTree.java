package com.example.leetcode.tree;

public class DiameterOfTree {
    //*** same to max path sum of a tree problem
    private int max=Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        //***path is the number of the vertices connecting these nodes
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return -1;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        max = Math.max(max, left + right + 2);
        return 1 + Math.max(left, right);
    }

}
