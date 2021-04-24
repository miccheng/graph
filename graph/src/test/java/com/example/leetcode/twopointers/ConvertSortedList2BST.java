package com.example.leetcode.twopointers;

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
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //cut left sub list here
        TreeNode n = new TreeNode(slow.val);
        n.left = sortedListToBSTR(head);
        n.right = sortedListToBSTR(slow.next);
        return n;
    }


    public static TreeNode sortedListToBST(ListNode head) {
        ListNode origin = head;
        ListNode headCopy = head;

        int len = getLen(head);

        ListNode node = findRoot(len, headCopy);

        ListNode previous = reverseListLeftHalf(origin);

        ListNode forward= node.next;

        //build tree, starting from both sides
        TreeNode root = new TreeNode(node.val);
        root.left=new TreeNode(previous.val);
        root.right=new TreeNode(forward.val);

        TreeNode rightRoot = root.right;
        TreeNode leftRoot = root.left;

        constructTree(leftRoot, previous.next);
        constructTree(rightRoot, forward.next);

        return root;
    }

    private static TreeNode constructTree(TreeNode root, ListNode node) {
        //base case
        if(node==null) return root;

        if (root.val > node.val) {
            root.left = new TreeNode(node.val);
            TreeNode node1 = root.left;
            constructTree(node1, node.next);
        }
        if (root.val < node.val) {
            root.right = new TreeNode(node.val);
            TreeNode node2 = root.right;
            constructTree(node2, node.next);
        }
        return root;
    }

    private static ListNode reverseListLeftHalf(ListNode origin) {
        //reverse left side list
        ListNode previous = null;
        ListNode current = origin;
        while (current != null) {
            ListNode next = current.next;
            current.next=previous;
            previous = current;
            current=next;
        }//previous is the root of left side
        return previous;
    }

    private static ListNode findRoot(int len, ListNode headCopy) {
        int i = 0;
        ListNode left = null;
        //find the root and the node before root
        while (i < len / 2) {
            if (i == len / 2 - 1) left = headCopy;
            if (headCopy != null) headCopy = headCopy.next;
            i++;
        }
        left.next = null;//left break the left and root poninter

        return headCopy;
    }

    private static int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
