package com.example.leetcode.linkedlist;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if(head==null) return null;
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode root){
        if(root.next==null) return root;

        ListNode p1=root;
        ListNode p2=root;
        //check length>=3
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        ListNode start=p1.next;
        p1.next=null;

        ListNode node1= mergeSort(root);
        ListNode node2= mergeSort(start);
        return merge(node1, node2);
    }

    public static ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val){
                head.next=h1;
                h1=h1.next;
            }else{
                head.next=h2;
                h2=h2.next;
            }
            head=head.next;
        }

        if(h1!=null){
            head.next=h1;
        }
        if(h2!=null){
            head.next=h2;
        }

        return dummy.next;
    }
}
