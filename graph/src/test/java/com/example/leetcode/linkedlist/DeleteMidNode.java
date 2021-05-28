package com.example.leetcode.linkedlist;

public class DeleteMidNode {

    // scenario 1: If given the head node
    public void deleteMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            previous = slow;
            slow = slow.next;
        }
        previous.next = slow.next;
    }


}
