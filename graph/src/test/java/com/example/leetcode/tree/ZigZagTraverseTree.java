package com.example.leetcode.tree;

import java.util.*;


public class ZigZagTraverseTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.left = node9;
        root.right = node20;
        node20.left = new TreeNode(15);
        node20.right = new TreeNode(7);
        zigzagLevelOrder(root);

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        boolean leftToRight = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Integer size = queue.size();
            List<Integer> levelNode = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    levelNode.add(node.val);
                } else {
                    levelNode.add(0, node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            leftToRight = false;
            result.add(levelNode);
        }
        return result;
    }

    //TODO
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
