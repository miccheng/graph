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
        //use dummy head to avoid 1 node link list edge case
        ListNode start= new ListNode(-1);
        ListNode slow=start;
        ListNode fast=start;

        start.next=head;

        //traverse fast ahead n+1;
        for(int i=0; fast!=null &&i<=n; i++){
            fast=fast.next;
        }

        //move both pointers
        while( fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return start.next;
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
