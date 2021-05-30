package com.example.leetcode.linkedlist;

public class SumLists {
    //A: 1->5->9
    // B:2->3->6->7
    //result: 3->8->5->8
    public static void main(String[] args) {
        ListNode nodex = new ListNode(7);
        ListNode node6 = new ListNode(6, nodex);
        ListNode node5 = new ListNode(3, node6);
        ListNode node2 = new ListNode(2, node5);

        ListNode node1 = new ListNode(9);
        ListNode node3 = new ListNode(5, node1);
        ListNode node4 = new ListNode(1, node3);
        addLinkedlistRecursive(node4, node2, 0);
    }

    //**Solution 1: iterative
    public static ListNode addLinkedlist(ListNode n1, ListNode n2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        int carryover = 0;
        while (n1 != null || n2 != null || carryover!=0) {
            int val1 = n1 == null ? 0 : n1.val;
            int val2 = n2 == null ? 0 : n2.val;
            int value = val1 + val2 + carryover;
            if (value > 10) {
                carryover = value / 10;
                value = value % 10;
            }
            dummyHead.next = new ListNode(value);
            dummyHead = dummyHead.next;

            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }

        return head.next;
    }

    //Solution 2: recursive
    public static ListNode addLinkedlistRecursive(ListNode n1, ListNode n2, int carryOver) {
        int value = carryOver;
        if (n1 != null) {
            value += n1.val;
        }
        if (n2 != null) {
            value += n2.val;
        }
        if (n1 == null && n2 == null && carryOver==0) {//***3 all have to be null
            return null;
        }
//        if (n1 != null && n2 != null) {
//            value+= n1.val + n2.val ;
//        } else if (n1 != null) {
//            value+= n1.val;
//        } else if (n2 != null) {
//            value+= n2.val;
//        } else if(n1==null&&n2==null) {//n1==n2==null
//            return null;
//        }

        if (value > 10) {
            carryOver = value / 10;
            value = value % 10;
        }
        ListNode node = new ListNode(value);

        node.next = addLinkedlistRecursive(n1 == null ? null : n1.next, n2 == null ? null : n2.next, carryOver);

        return node;
    }
}
