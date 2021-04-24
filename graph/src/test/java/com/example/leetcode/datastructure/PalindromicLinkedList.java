package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromicLinkedList {
//    check if a linked list is palindromic where each node stores a character
    public boolean isPalindrome(Node head) {
        Node copy = head;
        Deque<Node> stack = new ArrayDeque<>();

        while (copy != null) {
            stack.push(copy);
            copy = copy.next;
        }

        while (head != null) {
            Node pop = stack.pop();
            if (pop != head) return false;
            head = head.next;
        }
        return true;
    }


    class Node {
        int data;
        Node next;

        Node(int d) {
            next = null;
            data = d;
        }
    }
}
