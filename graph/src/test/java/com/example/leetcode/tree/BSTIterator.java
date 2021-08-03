package com.example.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    Deque<TreeNode> toReadstack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushAllLeft(root, toReadstack);
    }

    public int next() {
        TreeNode node = toReadstack.pop();
        pushAllLeft(node.right, toReadstack);
        return node.val;
    }

    public boolean hasNext() {
        return !toReadstack.isEmpty();
    }

    private void pushAllLeft(TreeNode root, Deque<TreeNode> toReadstack) {
        TreeNode current = root;
        while (current != null) {
            toReadstack.push(current);
            current = current.left;
        }
    }


}
