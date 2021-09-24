package com.example.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node, Node> map=new HashMap<>();

        Node node=head;
        while(head!=null){
            map.put(head, new Node(head.val));
            head=head.next;
        }

        head=node;
        while(head!=null){
            map.get(head).random=map.get(head.random);
            map.get(head).next=map.get(head.next);
            head=head.next;
        }

        return map.get(node);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
