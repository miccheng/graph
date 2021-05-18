package com.example.leetcode.tree;


public class DistanceBetweenTwoNodes {
    static int result = Integer.MAX_VALUE;
    static Integer pre = null;

    //Solution1: find LCA+ depth of tree problem. Count the distance to ancestor each and add them up
    public static int distanceBetween2Nodes(TreeNode root, TreeNode p, TreeNode q ) {
        int distance = 0;
        TreeNode ancester = findCommonAncester(root, p, q);

        //calculate both nodes distance from LCA;
        int level1 = findLevelOfNode(ancester, p);
        int level2 = findLevelOfNode(ancester, q);

        distance = level1 + level2;
        return distance;
    }

    private static int findLevelOfNode(TreeNode root, TreeNode p) {
        if (root == null) return -1;
        if (root == p) return 0;

        int depth1 = findLevelOfNode(root.left, p);
        int depth2 = findLevelOfNode(root.right, p);

        int depth = depth2 >= depth1 ? depth2 : depth1;
        if (depth > 0) depth++;
        return depth;
    }

    public static TreeNode findCommonAncester(TreeNode root,TreeNode p, TreeNode q ) {
        if (root == null || p == root || q == root) return root;

        TreeNode left = findCommonAncester(root.left, p, q);
        TreeNode right = findCommonAncester(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ?right:left;
    }

    //Solution2: Traverse tree and recording its previous node val
//    Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
    public static int getMinimumDifference(TreeNode root) {
        traverse(root);
        return result;
    }
    //***inorder traverse
    public static int traverse(TreeNode root) {
        if (root.left != null) traverse(root.left);

        if (pre != null) result = Math.min(result, root.val - pre);
        pre = root.val;//***update the

        if (root.right != null) traverse(root.right);
        return result;
    }


}
