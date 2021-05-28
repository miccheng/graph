package com.example.leetcode.linkedlist;

public class DeleteMidRandom {
    //Scenario 2: if only given a random node in the mid of the list, delete that node
    public boolean deleteNode(ListNode mid){
       if(mid==null||mid.next==null) return false;
       //copy the next node's val over to mid, and then delete the next node
       mid.val=mid.next.val;
       mid.next=mid.next.next;
       return true;
    }
}
