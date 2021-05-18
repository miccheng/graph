package com.example.leetcode.linkedlist;

//join the head and tail, and cut it
public class RotateList {
    ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1; // number of nodes
        ListNode tail = head;

        while (tail.next != null) {  // get the number of nodes in the list
            tail = tail.next;
            len++;
        }

        tail.next = head; // circle the link

        for (int i = 0; i < len - k % len; i++)
            tail = tail.next; // the tail node is the (len-k)-th node (1st node is head)

        head = tail.next;
        tail.next = null;
        return head;
    }
}
