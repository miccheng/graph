package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[]={4,10,4,3,8,9};
        findLIS(arr);
    }

    public static int findLIS(int [] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }
}
