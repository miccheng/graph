package com.example.leetcode.recursive.backtracking;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllRoot2LeafNode {
    //    10 –> 8 –> 3
//    10 –> 8 –> 5
//    10 –> 2
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node8 = new TreeNode(8);
        TreeNode node2 = new TreeNode(2);
        root.left = node8;
        root.right = node2;
        node8.left = new TreeNode(3);
        node8.right = new TreeNode(5);
        printPaths(root);
    }

    public static void printPaths(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        recursiveCall(result, new ArrayList<TreeNode>(), root);
        System.out.println();
    }

    private static void recursiveCall(List<List<TreeNode>> result, List<TreeNode> path, TreeNode root) {
        //base case
        if (root == null) return;
        path.add(root);
        //last element
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            return;
        }

        recursiveCall(result, path, root.left);
        path.remove(path.size()-1);
        recursiveCall(result, path, root.right);
        path.remove(path.size()-1);
    }
}
