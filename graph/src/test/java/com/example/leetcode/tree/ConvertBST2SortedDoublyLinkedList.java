package com.example.leetcode.tree;

public class ConvertBST2SortedDoublyLinkedList {

    private static Node previous=new Node(-1,null,null);

    public static Node treeToDoublyList(Node root) {
        if(root==null) return null;
        Node dummy=previous;
        inorder(root);

        dummy.right.left=previous;
        previous.right=dummy.right;
        return dummy.right;
    }

    private static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        //link the current node
        previous.right=root;
        root.left=previous;
        //move pointer forward
        previous=root;

        inorder(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
