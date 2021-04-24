package com.example.leetcode.binarysearch;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//Given a binary search tree, return a balanced binary search tree with the same node values.
public class BalanceABST {

    public TreeNode balanceBST(TreeNode root) {
        //traverse all tree to collect all the nodes
        List<TreeNode> nodes = new ArrayList<>();
        inOrderTraverse(root, nodes);

        return sortedArrayToBST(0,nodes,nodes.size()-1);

    }

    private TreeNode sortedArrayToBST(int left, List<TreeNode> nodes, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nodes.get(mid).val);

        root.left = sortedArrayToBST(left, nodes, mid - 1);
        root.right = sortedArrayToBST(mid + 1, nodes, right);
        return root;
    }

    private void inOrderTraverse(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        inOrderTraverse(root.left, nodes);
        nodes.add(root);
        inOrderTraverse(root.right, nodes);
    }
}
