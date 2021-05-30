package com.example.leetcode.linkedlist;

public class SumListReverse {
    //A: 6->1->7
    // B:2->9->5
    //Result:9->1->5
    //TODO
    public static void main(String[] args) {
        ListNode nodex = new ListNode(7);
        ListNode node5 = new ListNode(1, nodex);
        ListNode node2 = new ListNode(6, node5);

        ListNode node1 = new ListNode(5);
        ListNode node3 = new ListNode(9, node1);
        ListNode node4 = new ListNode(2, node3);
        sumListsRecursive(node4, node2);
    }

    private static int sumListsRecursive(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) return Integer.MIN_VALUE;
        int carryoverSum = sumListsRecursive(n1.next == null ? null : n1.next, n2.next == null ? null : n2.next);
        ListNode nodeInner = carryoverSum == Integer.MIN_VALUE ? null :new ListNode(carryoverSum % 10);

        int sum;
        if(carryoverSum == Integer.MIN_VALUE){
            sum=0;
        }else{
            sum = carryoverSum > 10 ? carryoverSum / 10 : carryoverSum;
        }

        if (n1 != null) sum += n1.val;
        if (n2 != null) sum += n2.val;
        ListNode node = new ListNode(sum % 10);
        node.next = nodeInner;
        return sum;
    }

}
