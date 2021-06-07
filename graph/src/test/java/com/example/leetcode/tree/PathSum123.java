package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum123 {
//Given the root of a binary tree and an integer targetSum, return true if the tree has
// a root-to-leaf path such that adding up all the values along the path equals targetSum.

    //preorder
    //Path Sum I: exist
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //2 base cases
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    //Path Sum II: return all the paths
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=  new ArrayList<>();
        findPath(root, targetSum,result, new ArrayList<Integer>());
        return result;
    }

    private void findPath(TreeNode root, int targetSum, List<List<Integer>> result, ArrayList<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        if(root.left==null&&root.right==null&&root.val==targetSum){
            result.add(new ArrayList(path));
        }
        findPath(root.left, targetSum-root.val, result, new ArrayList(path));
        findPath(root.right, targetSum-root.val, result, new ArrayList(path));
    }

    //Path Sum III: return all the paths
}

