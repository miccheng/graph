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

    //Solution2: Get Subtree Deepest Depth
    int deepest = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeavesD(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }
}
