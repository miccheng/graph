package com.example.leetcode.tree;

public class CheckBalanced {
    boolean isBalancedSell(TreeNode root) {
        if (isBalanced(root) ==Integer.MIN_VALUE) return false;
        return true;
    }

    public int isBalanced(TreeNode root) {
        if (root == null) return -1;

        int h1 = isBalanced(root.left) + 1;
        //pass error up instead of going back to recurse
        if (h1 == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int h2 = isBalanced(root.right) + 1;
        if (h2 == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(h1 - h2) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(h1, h2);// pass the tree's height
    }
}
