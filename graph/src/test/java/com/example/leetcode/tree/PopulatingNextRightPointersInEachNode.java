package com.example.leetcode.tree;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root==null) return root;
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node top=queue.pop();
                if(i==size-1){
                    top.next=null;
                }else{
                    top.next=queue.peek();
                }
                if(top.left!=null) queue.add(top.left);
                if(top.right!=null) queue.add(top.right);
            }
        }
        return root;
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
    }
}
