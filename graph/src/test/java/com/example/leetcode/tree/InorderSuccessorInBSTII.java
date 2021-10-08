package com.example.leetcode.tree;

public class InorderSuccessorInBSTII {
    //find the next node(in order traversal) of a given node in a binary tree. Assume node has link to its parent node

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    public Node inorderSuccessor(Node node) {
        if (node == null) return node;

        if (node.right != null) {
            Node cur = node.right;
            Node result = cur;
            while (cur != null) {
                if (cur.val < result.val) result = cur;
                cur = cur.left;
            }
            return result;
        } else {
            Node cur = node;
            while (cur != null && cur.val <= node.val) {
                cur = cur.parent;
            }
            return cur;
        }
    }
}
