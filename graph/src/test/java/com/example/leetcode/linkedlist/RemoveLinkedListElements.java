package com.example.leetcode.linkedlist;

public class RemoveLinkedListElements {
    //Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;

        while(head!=null){
            if(head.val!=val){
                cur.next=head;
                cur=cur.next;
            }
            head=head.next;
        }
        cur.next=null;
        return dummy.next;
    }
}
