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

    //*** Key: To identify nth node, we use runners approach to maintain a gap of n between 2 pointers,
    // but to deleted the Nth node, we need to keep track of one node ahead of it-->(n+1) node.
    // so we will need to maintain a gap of (n+1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //preserve head
        ListNode start=head;

        //identify (n+1) from end node. Maintain a gap of (n+1) distance between two pointers
        for (int i = 0; fast != null && i <n+1; i++) {//move (n+1) step
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //Skip the desired node
        slow.next = slow.next.next;
        return start;
    }

    //***Solution 2: recursive. base case return 0
    public static int identifyNthFromEnd(ListNode head, int k) {
        if (head == null) return 0;
        int sum = identifyNthFromEnd(head.next, k) + 1;
        if (sum == k) {
            System.out.println(head.val);
        }
        return sum;
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
