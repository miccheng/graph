package com.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BoundaryTraversalOfBinaryTree {
//    split the problem into 3 parts:
//        1.traverse left boundary (downwards) preorder
//        2. all leaf nodes dfs
//        3.traverse right boundary (upwards) postorder
//      avoid duplicates: left and right boundary and the leaf nodes

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        if(isLeaf(root)) {
            return result;
        }

        getLeftBoundary(root.left, result);
        collectLeaves(root, result);

        getRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void collectLeaves(TreeNode root,List<Integer> set) {
        if (root == null) return;
        if (isLeaf(root)) {
            set.add(root.val);
            return;
        }

        collectLeaves(root.left, set);
        collectLeaves(root.right, set);
    }

    private void getLeftBoundary(TreeNode root, List<Integer> set) {
        if (root == null) return;
        if (!isLeaf(root)) {
            set.add(root.val);
        }
        if (root.left != null) {
            getLeftBoundary(root.left, set);
        } else {
            getLeftBoundary(root.right, set);
        }
    }

    private void getRightBoundary(TreeNode root, List<Integer> set) {
        if (root == null) return;

        if (root.right != null) {
            getRightBoundary(root.right, set);
        } else {
            getRightBoundary(root.left, set);
        }
        if (!isLeaf(root)) {
            set.add(root.val);
        }
    }
}
