package com.example.leetcode.tree;

public class LargestSmallerBSTKey {
    private TreeNode result;
    public int findLargestSmallerKey(int num, TreeNode root) {
        if(root==null) return -1;
        preorder(root, num);
        return result.val;
    }


    public void preorder(TreeNode root, int target){//10
        if(root==null) return;
        if(root.val<target){
            result.val=Math.max(root.val, result.val);
        }
        if(root.val>=target){
            preorder(root.left,target);//9 10  //11 10
        }else{
            preorder(root.right,target);////12 10

        }

    }
}
