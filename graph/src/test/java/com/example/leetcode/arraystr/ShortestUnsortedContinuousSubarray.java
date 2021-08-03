package com.example.leetcode.arraystr;

public class ShortestUnsortedContinuousSubarray {
    //Solution 1: sort the array and compare the mismatch point

    //O(n) time complexity
    //Solution 2: find boundary
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int len=nums.length;

        int premin=Integer.MIN_VALUE;
        int premax=Integer.MAX_VALUE;
        int end=-1;
        int beg=len;
        //end-> beg all the numbers on beg should be > than end, if not, it is out of place. Find the last index of out of place number
        for(int i=0;i<len;i++){
            if(nums[i]<premin){
                end=i;
            }else{
                premin=nums[i];
            }
        }
        //same logic from beg to end
        for(int j=len-1;j>=0;j--){
            if(nums[j]>premax){
                beg=j;
            }else{
                premax=nums[j];
            }
        }
        // if the original array is sorted
        if(end!=-1) return end-beg+1;
        return 0 ;
    }


    //Solution 2: monotonic stack

}
