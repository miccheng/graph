package com.example.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//TODO
public class ZigZagTraverseTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node8 = new TreeNode(8);
        TreeNode node2 = new TreeNode(2);
        root.left = node8;
        root.right = node2;
        node8.left = new TreeNode(3);
        node8.right = new TreeNode(5);
        printZigZagTraversal(root);
    }

    public static List<TreeNode> printZigZagTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> currentStack = new ArrayDeque<>();
        Deque<TreeNode> nextStack = new ArrayDeque<>();

        nextStack.push(root);
        boolean current = true;
        while (!currentStack.isEmpty() || !nextStack.isEmpty()) {
            TreeNode node = currentStack.pop();
            if (!current) {
                if (!currentStack.isEmpty()) {
                    node = currentStack.pop();
                    result.add(node);
                }
            } else {
                if (!nextStack.isEmpty()) {
                    node = nextStack.pop();
                    result.add(node);
                }
            }
        }

        return result;
    }
}
