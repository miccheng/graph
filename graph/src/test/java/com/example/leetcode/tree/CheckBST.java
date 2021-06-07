package com.example.leetcode.tree;

public class CheckBST {
    //straightforward approach: do an in-order traversal, gather all the nodes in the array, and check whether
    //array is sorted. But when checking array, we are only comparing the ele with previous ele. So allocate an array is
    //not necessary.

    //Solution 1: Key: shift the previous and what to return at base case
     Integer previous=Integer.MIN_VALUE;
     boolean  isBST(TreeNode root) {
        if(root==null) return true;

        //left
        if (!isBST(root.left)) return false;
        if (root.val < previous) {
            return false;
        }

        //right
        previous = root.val;
        if(!isBST(root.left)) return false;
        return true;
    }

//  *****Solution 2: keep min && max , update the range and check progressively
    boolean  isBSTM(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val > maxValue) return false;
        if (!checkBST(root.left, minValue, root.val) || !checkBST(root.right, root.val, maxValue)) return false;
        return true;
    }
}
