package com.example.leetcode.datastructure;

import sun.reflect.generics.tree.Tree;

public class SubtreeOfTree {
    public static void main(String args[]) {
        TreeNode node7 = new TreeNode(7);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4,node1,node2);

        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6,node7,node4);
        TreeNode s = new TreeNode(3,node5,node6);

        TreeNode t = new TreeNode(4,node1,node2);

        boolean b = isSubtree(s, t);
        System.out.println();
    }

//solution 1
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        //traversal tree
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSame(s.left, t) || isSame(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


    //solution 2
    public boolean isSubTree(TreeNode t, TreeNode s) {
        if (t == null || s==null) return false;
        if (isSamesub(t, s)) return true;
        return false;
    }

    private boolean isSamesub(TreeNode t, TreeNode s) {
        //base: hit bottom
        if(t==null && s==null) return true;
        if(t==null || s==null) return false;

        if (t.val == s.val) {
            return (t.left == s.left) && (t.right == s.right);
        } else {// (t.val != s.val)
            boolean b = isSamesub(t.left, s);
            boolean d = isSamesub(t.right, s);
            if (b == true || d == true) return true;
        }
        return false;
    }


}
