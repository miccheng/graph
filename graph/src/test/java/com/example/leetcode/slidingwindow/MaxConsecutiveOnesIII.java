package com.example.leetcode.slidingwindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        int len=nums.length;
        int i=0; int j=0;

        int max=0;
        int count=0;
        while(j<len){
            count+=nums[j]==1?0:1;
            while(count>k){
                count-=nums[i]==1?0:1;
                i++;
            }
            max=Math.max(max, j-i+1);
            j++;
        }

        return max;
    }
}
