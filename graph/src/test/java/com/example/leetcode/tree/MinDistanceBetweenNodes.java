package com.example.leetcode.tree;

import java.util.Arrays;
import java.util.TreeSet;

public class MinDistanceBetweenNodes {
//Scenario 1(BST): inOrder traverse the tree. ONlY need compare the delta between each of the adjacent values.
    private int distance = Integer.MAX_VALUE;
    private Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return distance;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        //root
        if (prev != null) {
            distance = Math.min(distance, root.val - prev);
        }
        prev = root.val;
        inOrder(root.right);
    }

//Scenario 2: NOT a BST
    //use treeset
    private TreeSet<Integer> treeSet=new TreeSet<Integer>();
    private int min=Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if(root==null) return min;

        if(!treeSet.isEmpty()){
            if(treeSet.floor(root.val)!=null){
                min=Math.min(root.val-treeSet.floor(root.val),min);
            }
            if(treeSet.ceiling(root.val)!=null){
                min=Math.min(root.val-treeSet.ceiling(root.val),min);
            }
        }
        treeSet.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }


}
