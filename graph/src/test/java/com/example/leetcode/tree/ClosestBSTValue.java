package com.example.leetcode.tree;

public class ClosestBSTValue {
    private double dis=Integer.MAX_VALUE;
    private TreeNode closest=null;

    public int closestValue(TreeNode root, double target) {
        if(root==null) return 0;
        recursive(root, target);
        return closest.val;
    }

    private void recursive(TreeNode root, double target){
        if(root==null) return ;
        if(Math.abs(root.val-target)<dis){
            dis=Math.abs(root.val-target);
            closest=root;
        }
        if(target<root.val)recursive(root.left,target);
        if(target>root.val)recursive(root.right,target);
    }
}
