package com.example.leetcode.tree;

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

        boolean b = isSubTree(s, t);
        System.out.println();
    }

//solution 1
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;//big tree empty, substree still not found
        else if (s.val == t.val && matchTree(s, t))//find the matching head node
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean matchTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if(s==null || t==null)
            return false;
        else if (s.val != t.val)
            return false;
        return matchTree(s.left, t.left) && matchTree(s.right, t.right);
    }



    //solution 2
    public static boolean isSubTree(TreeNode t, TreeNode s) {
        if (t == null || s==null) return false;
        if (isSamesub(t, s)) return true;
        return false;
    }

    private static boolean isSamesub(TreeNode t, TreeNode s) {
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
