package com.example.leetcode.linkedlist;

//join the head and tail, and cut it
public class RotateList {
    //identify the node to cut and preserve the node after the cut, as it will be the new head to return
    //1 pass, however the k is not mod
    ListNode rotateRight2(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;

        //maintain a gap of K
        for(int i=0;i<k;i++){
            fast=fast.next;
        }

        ListNode previous=fast;
        while(fast.next!=null){
            previous=fast;
            fast=fast.next;
            slow=slow.next;
        }

        fast.next=head;//circle the list
        slow.next=null;//cut it
        return previous;
    }

    ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 1; // number of nodes
        ListNode tail = head;

        while (tail.next != null) {  // get the number of nodes in the list
            tail = tail.next;
            len++;
        }

        tail.next = head; // circle the link

        for (int i = 0; i < (len - k) % len; i++)
            tail = tail.next; // the tail node is the (len-k)-th node (1st node is head)

        head = tail.next;
        tail.next = null;
        return head;
    }
}
