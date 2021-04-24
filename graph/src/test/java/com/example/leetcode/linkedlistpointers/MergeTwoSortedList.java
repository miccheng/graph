package com.example.leetcode.linkedlistpointers;

public class MergeTwoSortedList {

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        //if one of the list is not exhausted yet
        if (l1 != null) {
            current = l1.next;
            l1 = l1.next;
        }

        if (l2 != null) {
            current = l2.next;
            l2 = l2.next;
        }

        return dummyHead.next;
    }
}
