package com.example.graph.leetcode.recursiveDFSBFS;

import com.example.leetcode.tree.TreeNode;

import java.util.LinkedList;

public class CompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layer = 0;
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }

        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
