package com.example.leetcode.tree;

public class CommonAncester {
//    3     Given Binary Tree, find the Lowest Common Ancestor
//  5   1
// 6 2 0 8
    //preorder
    //solution1: ***lift up the founded node up along the tree
    public static TreeNode lowestCommonAncestorOfTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorOfTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorOfTree(root.right, p, q);

        if (left != null && right != null) return root;//where it splits
        else if(left == null && right == null) return null;
        return left == null ? right : left;
    }

    //Solution2: postorder Traverse tree with boolean
    //experiment with preorder
    public TreeNode LCATraverse(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        boolean b = LCA(root, p, q, ancestor);
        if(ancestor==null && b==true)
            return root;
        else if(ancestor!=null)
            return ancestor;
        return null;
    }

    private boolean LCA(TreeNode root, TreeNode p, TreeNode q, TreeNode ancestor) {
        //traverse the tree
        if (root == null) return false;
        if (root == p || root == q) return true;

        boolean left = LCA(root.left, p, q, ancestor);
        boolean right = LCA(root.right, p, q, ancestor);

        if (left && right)
            ancestor = root;
        else if(left==true )
            ancestor=root.right;
        else
            ancestor=root.left;

        return left || right;
    }


    //*** Given a binary search tree (BST), find the lowest common ancestor
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
