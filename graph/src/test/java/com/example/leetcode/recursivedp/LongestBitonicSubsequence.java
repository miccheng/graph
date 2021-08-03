package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int LongestBitonicSequence(int[] nums){
        if(nums==null || nums.length==0) return 0;
        int len=nums.length;

        //front -> back LIS
        int dp1[]=new int[len];
        int dp2[]=new int[len];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);


        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]) dp1[i]=Math.max(dp1[i], dp1[j]+1);
            }
        }

        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>i;j--){
                if(nums[j]<nums[i]) dp2[i]=Math.max(dp2[i], dp2[j]+1);
            }
        }


        //add up both dp1+dp2 at same index
        int max=1;
        for(int k=0; k<len;k++){
            max=Math.max(max, dp1[k]+dp2[k]);
        }

        return max-1;
    }
}
