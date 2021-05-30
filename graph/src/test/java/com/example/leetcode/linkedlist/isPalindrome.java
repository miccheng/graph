package com.example.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class isPalindrome {
    //Solution 1: reverse clone and compare 2 linked lists
    public ListNode reverseAndClone(ListNode head){
        ListNode previous=null;
        while(head !=null){
            ListNode node = new ListNode(head.val);
            node.next=previous;
            previous=node;

            head=head.next;
        }
        return previous;
    }

    //Solution 2: leverage stack
    public  boolean isPalindromeStack(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        //****determine odd or even
        if (fast != null) slow = slow.next;

        while (slow != null) {
            if (slow != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }
}
