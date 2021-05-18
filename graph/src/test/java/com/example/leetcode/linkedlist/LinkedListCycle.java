package com.example.leetcode.linkedlist;

public class LinkedListCycle {
    //*** Application: find duplicate number in array
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null || fast.next != null) {
            if (slow == fast) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

//    https://leetcode.com/problems/linked-list-cycle-ii/
//    same as findDuplicateNumber in array
    public ListNode detectCycle(ListNode head) {
        //has Cycle
        boolean b = hasCycle(head);
        if (!b) return null;
        //set fast/ faster , either one at head, and move them both 1 step each time.
        // where they meet next is where the joint is.
        return null;
    }
}
