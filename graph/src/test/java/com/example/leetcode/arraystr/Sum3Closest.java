package com.example.leetcode.arraystr;

import java.util.Arrays;

public class Sum3Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=0;
        int gap=Integer.MAX_VALUE;
        int len=nums.length;

        for(int i=0;i<len;i++){
            int j=i+1;
            int k=len-1;
            while(j<k){
                int total=nums[i]+nums[j]+nums[k];
                if(Math.abs(total-target)<gap){
                    sum=total;
                    gap=Math.abs(total-target);
                }

                if(total==target){
                    return target;
                }else if(total<target){
                    j++;
                }else{
                    k--;
                }

            }
        }

        return sum;
    }
}
