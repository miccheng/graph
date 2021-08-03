package com.example.leetcode.tree;

public class MaximumPathSum {
    private int max=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;

        int result=recursive(root);
        return Math.max(result, max);
    }

    private int recursive(TreeNode root){
        if(root==null) return 0;

        int left=Math.max(recursive(root.left),0);
        int right=Math.max(recursive(root.right),0);
        max=Math.max(max,left+root.val+right);

        return Math.max(left, right)+root.val;
    }

}
