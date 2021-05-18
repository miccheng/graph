package com.example.leetcode.linkedlist;

import java.util.HashSet;

public class IntersectionPointOfLinkedlist {
    //solution O(n) time and O(1) space
    //join two lists together to remove the obstacle of len1 !=len2
    public static Node getIntersectionNodeBest(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node a_pointer = headA;
        Node b_pointer = headB;

        while (a_pointer != b_pointer) {
            a_pointer = a_pointer == null ? headB : a_pointer.next;
            b_pointer = b_pointer == null ? headA : b_pointer.next;
        }
        return a_pointer;
    }


    //solution 3 : use hashing
    public static Node getIntersectionNode(Node n1, Node n2) {
        HashSet<Node> nodes = new HashSet<>();
        while (n1 != null) {
            nodes.add(n1);
            n1 = n1.next;
        }
        while (n2 != null) {
            if (nodes.contains(n2)) return n2;
            n2 = n2.next;
        }
        return null;
    }

    //solution 2 : mark node visited

    //solution 1 : 2 for loops

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
