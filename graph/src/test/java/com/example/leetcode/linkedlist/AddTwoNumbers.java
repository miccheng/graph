package com.example.leetcode.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else if (l2 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
        }
        //[9,9,9],[9]
        if (carry == 1) head.next = new ListNode(1);//***have to go through until carry is 0
        return dummyHead.next;
    }
}
