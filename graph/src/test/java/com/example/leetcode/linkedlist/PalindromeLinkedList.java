package com.example.leetcode.linkedlist;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node0 = new ListNode(0, node4);
        ListNode node1 = new ListNode(1,node0);
        isPalindrome(node1);
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;

        ListNode mid=findMid(head);
        ListNode reversedH=reverseFirstHalf(mid,null);
        return compare(head, reversedH);
    }

    private static boolean compare(ListNode head, ListNode mid){
        if(mid==null) return true;
        if(head.val!=mid.val) return false;

        return compare(head.next, mid.next);
    }

    private static ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    private static ListNode reverseFirstHalf(ListNode head,ListNode previous){
        if(head==null) return previous;
        ListNode next=head.next;
        head.next=previous;

        return reverseFirstHalf(next, head);
    }
}
