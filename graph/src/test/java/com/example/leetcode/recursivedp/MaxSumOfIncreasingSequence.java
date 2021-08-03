package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class MaxSumOfIncreasingSequence {
    public int maxSumIS(int nums[], int len)  {
        if(nums==null || len==0) return 0;

        int [] dp;
        dp= Arrays.copyOf(nums,len);

        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(nums[j]>nums[i]) dp[i]=Math.max(dp[i],dp[j]+nums[i]);
            }
        }

        int max=Integer.MIN_VALUE;
        for(int m: nums){
            max=Math.max(m,max);
        }

        for(int n: dp){
            max=Math.max(n, max);
        }

        return max;
    }
}
