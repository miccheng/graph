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

    //solution 2:
    private int closest(TreeNode node, double target, int val) {
        if (node == null) return val;
        if (Math.abs(node.val - target) < Math.abs(val - target)) val = node.val;

        if (node.val < target)
            val = closest(node.right, target, val);
        else if (node.val > target)
            val = closest(node.left, target, val);
        return val;
    }

    //solution 3:
    //iterative
}
