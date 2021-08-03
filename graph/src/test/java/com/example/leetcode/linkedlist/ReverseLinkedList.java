package com.example.leetcode.linkedlist;

public class ReverseLinkedList {
    //solution 1:iterative
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    //solution 2: recursive
    public ListNode reverseListRecursive(ListNode head) {
        return reverse(head,null);
    }

    private ListNode reverse(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverse(next, head);
    }

}
