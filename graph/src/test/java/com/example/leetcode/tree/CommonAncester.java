package com.example.leetcode.tree;

public class CommonAncester {
    //Given Binary Tree, find the Lowest Common Ancestor
    //***Move up the found node up along the tree
    public static TreeNode lowestCommonAncestorOfTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorOfTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorOfTree(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.left == p && root.right == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

//    Given a binary search tree (BST), find the lowest common ancestor
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;

        //traversal left
        if(p.val< root.val &&q.val< root.val){
            lowestCommonAncestorBST(root.left,p,q);
        }
        //traversal right
        if(p.val> root.val &&q.val> root.val){
            lowestCommonAncestorBST(root.right,p,q);
        }
        return root;
    }


}
