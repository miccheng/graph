package com.example.leetcode.linkedlistpointers;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode start = dummyHead;
        ListNode fast = dummyHead;

        for (int i = 0; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            start = start.next;
        }

        //Skip the desired node
        start.next = start.next.next;
        return dummyHead.next;
    }
}
