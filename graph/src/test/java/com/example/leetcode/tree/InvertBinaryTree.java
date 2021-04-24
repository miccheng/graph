package com.example.leetcode.tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        while (root != null) {
            TreeNode left = invertTree( root.left);
            TreeNode right = invertTree(root.right);

            //swap
            root.left = right;
            root.right = left;
        }

        return root;
    }
}
