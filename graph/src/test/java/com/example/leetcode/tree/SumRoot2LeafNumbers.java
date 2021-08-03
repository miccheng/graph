package com.example.leetcode.tree;

public class SumRoot2LeafNumbers {
    private int sum=0;

    public int sumNumbers(TreeNode root) {
        if(root==null) return sum;
        preorder(root,0);
        return sum;
    }

    public void preorder(TreeNode root, int base){
        if(root.left==null&&root.right==null){
            sum+=base*10+root.val;
            return;
        }
        if(root.left!=null) preorder( root.left,  base*10+root.val);
        if(root.right!=null) preorder( root.right,  base*10+root.val);
    }
}
