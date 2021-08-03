package com.example.leetcode.recursivedp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinDeletionMakeSortedSequence {
    //conversion to problem: len- LIS
    public int minDeletions(int arr[], int n) {
        if(arr==null || n==0) return 0;
        int max=0;

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }

        for(int num : dp){
            max=Math.max(num,max);
        }
        return n-max;
    }
}
