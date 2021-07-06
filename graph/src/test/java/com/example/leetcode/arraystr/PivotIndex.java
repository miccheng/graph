package com.example.leetcode.arraystr;

public class PivotIndex {
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is
// equal to the sum of all the numbers strictly to the index's right.
    public int pivotIndex(int[] nums) {
        if(nums==null || nums.length==0) return -1;

        int len=nums.length;
        int prefix[]= new int[len];
        prefix[0]=nums[0];

        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        for(int i=0;i<len;i++){
            int front= i==0?0:prefix[i-1];
            int back=prefix[len-1]-prefix[i];
            if(front==back) return i;
        }

        return -1;
    }
}
