package com.example.leetcode.tree;

import com.example.leetcode.tree.TreeNode;

public class ConvertSortedList2BST {
    public static void main(String[] args) {
        ListNode node9 = new ListNode(9);
        ListNode node5 = new ListNode(5,node9);
        ListNode node0 = new ListNode(0, node5);
        ListNode node3 = new ListNode(-3, node0);
        ListNode head = new ListNode(-10,node3);
        sortedListToBSTR(head);
//        sortedListToBST(head);
    }

//**** 3 pointers + recursive
    public static TreeNode sortedListToBSTR(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);//***only 1 node left

        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //***cut left sub list here
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBSTR(head);
        n.right = sortedListToBSTR(slow.next);
        return n;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
