package com.example.leetcode.tree;

//leetcode116
public class PopulatingNextRightPointersInTree {
    //1. use next to preserve next level start
    //2. right to point to cur.next.left
    public Node connect(Node root) {
        Node cur=root;
        preorder(root,null);
        return root;
    }
    private void preorder(Node root,Node next) {
        if (root == null) return;
        root.next = next;
        preorder(root.left, root.right);
        preorder(root.right, root.next == null ? null : root.next.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
