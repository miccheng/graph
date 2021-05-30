package com.example.leetcode.linkedlist;

public class PartitionLinkedlist {
    public static void main(String[] args) {
        ListNode node6= new ListNode(1);
        ListNode node5= new ListNode(2, node6);
        ListNode node2= new ListNode(5,node5);
        ListNode node1= new ListNode(3, node2);
        ListNode node3= new ListNode(8,node1);
        ListNode node4= new ListNode(10,node3);
        partition2(node4,5);

    }

    //Solution 1: create before and after linked lists. Merge them in the end
    public static ListNode partition(ListNode node, int num){
       ListNode before= new ListNode(-1);
       ListNode beforeCopy=before;
       ListNode after= new ListNode(-1);
       ListNode afterCopy=after;
       while (node!=null) {
           if (node.val < num) {
               before.next = node;
               before = before.next;
           } else {
               after.next = node;
               after = after.next;
           }
           node = node.next;
       }
        //disconnect the original
        after.next=null;
        //join
       before.next=afterCopy.next;
       afterCopy.next=null;
       return beforeCopy.next;
    }

    //Solution 2: create head and tail, append to head/tail
    public static ListNode partition2(ListNode node, int num) {
        ListNode head = node;
        ListNode tail = node;

        ListNode current = node.next;
        while (current != null) {
            ListNode next = current.next;//preserve its next when if is taken
            if (current.val < num) {
                current.next = head;
                head = current;
            } else {
                tail.next = current;
                tail = current;
            }
            current = next;
        }

        tail.next = null;//disconnect to finish the else clause
        return head;
    }
}
