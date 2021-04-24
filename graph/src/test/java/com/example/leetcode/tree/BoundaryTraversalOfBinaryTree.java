package com.example.leetcode.tree;

public class BoundaryTraversalOfBinaryTree {
//    split the problem into 3 parts:
//        1.travese left boundary
//        2. all leaf nodes
//        3.travese right boundary
//      avoid duplicates: left and right boundary and the leaf nodes

    public void boundaryTraverse(TreeNode root){
        System.out.println(root);

        leftBoundary(root.left);
        leafNodes(root);
        rightBoundary(root.right);
    }

    //top down print
    public void leftBoundary(TreeNode root) {
        while (root != null) {
            if (isLeaf(root)) System.out.println(root);
            root = (root.left == null) ? root.left : root.right;
        }
    }

    //inorder traversal fashion
    public void leafNodes(TreeNode root) {
        if (root == null) return;
        leafNodes(root.left);
        if (isLeaf(root)) System.out.println(root);
        leafNodes(root.right);
    }

    //bottom up
    public void rightBoundary(TreeNode root) {
        if (root == null || isLeaf(root)) return; //overlapping of leaf node
        rightBoundary((root.right != null) ? root.right : root.left);
        // To ensure bottom-up order, print the value of the nodes after recursion unfolds
        System.out.print(root);
    }

    //check whether it is left node
    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
