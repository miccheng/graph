package com.example.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class InsertIntoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        //1 node has to connect to itself
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node copy=head;
        Node max=traverse(head, new HashSet<Node>());
        Node min=max.next;
        //no matter smaller<min, or bigger>max, append to max
        if(insertVal>=max.val||insertVal<=min.val){
            Node insert=new Node(insertVal);
            max.next=insert;
            insert.next=min;
        }else{//in between
            //start iteration from min to find the tipping point
            Node cur=min;
            while(cur.next!=null&&cur.next.val<insertVal){
                cur=cur.next;
            }
            Node next=cur.next;
            Node insert=new Node(insertVal);
            cur.next=insert;
            insert.next=next;
        }

        return copy;
    }

    private Node traverse(Node head, Set<Node> set ){
        Node max=head;
        while(set.add(head)){
            if(head.val>=max.val) max=head;
            head=head.next;
        }
        return max;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
