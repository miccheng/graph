package com.example.leetcode.datastructure;

import com.example.leetcode.linkedlist.ListNode;

//divide && conquer. same to merge sort
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeRecursive(lists,0,lists.length-1);
    }

    public ListNode mergeRecursive(ListNode[] lists, int start,int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left=mergeRecursive(lists, start, mid);
        ListNode right= mergeRecursive(lists, mid + 1, end);

        //merge
        return mergeLists(left,right);
    }

    //same as merge 2 sorted lists
    private ListNode mergeLists(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        while (left != null) {
            current.next = left;
            left = left.next;
        }

        while (right != null) {
            current.next = right;
            right = right.next;
        }
        current = current.next;
        return head.next;
    }
}
