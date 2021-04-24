package com.example.leetcode.datastructure;

import java.util.HashSet;

public class IntersectionPointOfLinkedlist {
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
