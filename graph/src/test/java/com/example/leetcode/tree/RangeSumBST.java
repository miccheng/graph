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


}
