package com.example.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
// path and subtree both are counted as path

public class BinaryTreeMaxPathSum {
    //***must store as property. !input parameter
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left =Math.max(0, postOrder(root.left));//bound it to 0 if it is negative
        int right =Math.max(0, postOrder(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}