package com.example.leetcode.tree;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class LCAOfDeepestLeaves {
    private TreeNode LCA = new TreeNode();
    private int max = -1;

    //Solution1: function return the subtree height and lca and at the same time.
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    private Pair getLca(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);
        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);
        if (l.d == r.d) {
            return new Pair(root, l.d);
        } else {
            return l.d > r.d ? l : r;
        }
    }

    class Pair {
        TreeNode node;
        int d;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    //Solution2: Observation: when left and right both equals to the deepest level, the result node is updated
    int maxLevel=0;
    TreeNode lca=null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null) return null;
        dfs(root,0);
        return lca;
    }

    private int dfs(TreeNode root, int level){
        if(root==null) return level;
        int left=dfs(root.left, level+1);
        int right=dfs(root.right, level+1);

        maxLevel=Math.max(maxLevel, Math.max(left, right));
        if(left==maxLevel&&right==maxLevel){
            lca=root;
        }
        return Math.max(left,right);
    }
}
