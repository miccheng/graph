package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutiveSequence {
    //Longest Consecutive Sequence of a binary tree
    public static void main(String args[]) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node4.right=node5;
        TreeNode node3 = new TreeNode(3);
        node3.right=node4;
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right=node3;
        node1.left=node2;

        List<TreeNode> list = findLongestSequence2(node1);
        System.out.println(list);
    }

    //last count-1
   public int findLongestSequence(TreeNode root){
       if(root==null) return 0;
       int count=0;

       //body
       int leftLen=0;
       int rightLen=0;
       if (root.left.val > root.val) {
           findLongestSequence(root.left);
       }
       if (root.right.val > root.val) {
           findLongestSequence(root.right);
       }
       count+=Math.max(leftLen,rightLen)+1;

       return count;
   }

    public static List<TreeNode> findLongestSequence2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;

        List<TreeNode> lNodes = new ArrayList<>();
        List<TreeNode> rNodes = new ArrayList<>();

        //body
        if (root.left != null && root.left.val > root.val) {
            lNodes.add(root.left);
            List<TreeNode> leftList = findLongestSequence2(root.left);
            lNodes.addAll(leftList);
        }
        if (root.right != null && root.right.val > root.val) {
            rNodes.add(root.right);
            List<TreeNode> rightList = findLongestSequence2(root.right);
            rNodes.addAll(rightList);
        }
        result = lNodes.size() > rNodes.size() ? lNodes : rNodes;
        return result;
    }
}
