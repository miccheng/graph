package com.example.leetcode.datastructure.design;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        node = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }

//    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//
//    public BSTIterator(TreeNode root) {
//        pushAll(root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        TreeNode tmpNode = stack.pop();
//        pushAll(tmpNode.right);
//        return tmpNode.val;
//    }
//
//    private void pushAll(TreeNode node) {
//        while (node != null) {
//            stack.push(node);
//            node = node.left;
//        }
//    }
}
