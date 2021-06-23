package com.example.leetcode.linkedlist;

public class MergeTwoSortedList {
    //***Solution 1: iterate linkedlist
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        //edge cases!!!
        if(l1==null) return l2;
        if(l2==null) return l1;

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
            current = l1;
        }

        if (l2 != null) {
            current = l2;
        }

        return dummyHead.next;
    }

    public ListNode mergeTwoListRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        //base case
        if(l1==null) return l2;
        if(l2==null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoListRecursive(l1, l2.next);
            return l1;
        } else {
            l2.next = mergeTwoListRecursive(l1.next, l2);
            return l2;
        }

    }


}
