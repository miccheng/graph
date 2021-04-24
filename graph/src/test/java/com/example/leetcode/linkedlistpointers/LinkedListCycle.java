package com.example.leetcode.linkedlistpointers;

public class LinkedListCycle {
    //*** Application: find duplicate number in array
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head;
        ListNode faster = head;

        while (fast != null || faster.next != null) {
            if (fast == faster) return false;
            fast = fast.next;
            faster = faster.next.next;
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
