package com.example.leetcode.datastructure;

import com.example.leetcode.linkedlist.ListNode;

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {
//        lists = [[1,4,5],[1,3,4],[2,6]]

        ListNode node2 = new ListNode(5);
        ListNode node1 = new ListNode(4,node2);
        ListNode head1 = new ListNode(1,node1);

        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode head2 = new ListNode(1,node3);

        ListNode node5 = new ListNode(6);
        ListNode head3 = new ListNode(2,node5);
        List<ListNode> listNodes = new ArrayList<>();

        mergeKListsE(new ListNode[]{head1,head2,head3});
    }
    //each inner array doesn't have to be sorted
    public static ListNode mergeKListsE(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> queue = new PriorityQueue<>((a,b)->b.val-a.val);
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
//      Arrays.sort(queue.toArray()); ***priority queue can't be traversed in order. Debug view!=actual order
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (!queue.isEmpty()) {
            head.next = queue.remove();
            head = head.next;
        }
        head.next=null;//***break the original pointer
        return dummyHead.next;
    }

}
