package com.example.leetcode.linkedlist;

import java.util.List;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node = new ListNode(1, node2);
        hasCycle(node);
    }
    //*** Application: find duplicate number in array
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;//check after move both pointers
        }
        return false;

//        while (true) {
//            tortoise = nums[tortoise];
//            hare = nums[nums[hare]];
//            if (tortoise == hare) break;
//        }
//        if (fast=null||fast.next==null) return null;//no collision found
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
