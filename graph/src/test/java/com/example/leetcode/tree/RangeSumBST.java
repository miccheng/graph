package com.example.leetcode.tree;

public class RangeSumBST {
    //solution 1:
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        int sum=preorder(root,low, high);
        return sum;
    }

    private int preorder(TreeNode root, int low, int high){
        if(root==null) return 0;

        if(root.val<low) return preorder(root.right, low, high);//exclude left
        if(root.val>high) return preorder(root.left, low, high);//exclude right

        return root.val+preorder(root.right, low, high)+preorder(root.left, low, high);
    }

    //solution 2:
    private int sum=0;

    public int rangeSumBSTT(TreeNode root, int low, int high) {
        if(root==null) return 0;
        preorderRecurisive(root,low, high);
        return sum;
    }

    private void preorderRecurisive(TreeNode root, int low, int high){
        if(root==null) return ;

        preorderRecurisive(root.left, low, high);
        if(root.val>=low && root.val<=high){
            sum+=root.val;
        }
        preorderRecurisive(root.right, low, high);
    }
}
