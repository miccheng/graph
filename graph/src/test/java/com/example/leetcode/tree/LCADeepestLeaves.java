package com.example.leetcode.tree;

public class LCADeepestLeaves {
    class Solution {
        private TreeNode LCA = new TreeNode();
        private int max = -1;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            inorder(root);
            return LCA;
        }

        public int inorder(TreeNode root) {
            if (root == null) return -1;
            int left = inorder(root.left);
            int right = inorder(root.right);

            if (left == right) {
                LCA = root;
            } else if (left > right) {
                LCA = root.left;
            } else {
                LCA = root.right;
            }

            return Math.max(left, right) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
