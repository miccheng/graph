package com.example.leetcode.linkedlist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        removeNthFromEnd(node1,2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode start = dummyHead;
        ListNode fast = dummyHead;
        //hook up with given list
        dummyHead.next=head;

        //maintain a gap of n distance between two pointers
        for (int i = 0; fast != null && i <= n; i++) {
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

      public static class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
}
