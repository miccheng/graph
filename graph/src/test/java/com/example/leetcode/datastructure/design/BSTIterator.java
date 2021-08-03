package com.example.leetcode.datastructure.design;

import com.example.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BSTIterator {
    Deque<TreeNode> toReadstack=new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushAllLeft(root,toReadstack);
    }

    public int next() {
        TreeNode node=toReadstack.pop();
        pushAllLeft(node.right,toReadstack);
        return node.val;
    }

    public boolean hasNext() {
        return !toReadstack.isEmpty();
    }

    private void pushAllLeft(TreeNode root, Deque<TreeNode> toReadstack){
        TreeNode current=root;
        while(current!=null){
            toReadstack.push(current);
            current=current.left;
        }
    }
}
