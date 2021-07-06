package com.example.leetcode.recursive.knapsack;

import java.util.Arrays;

public class SmallestSumCantForm {
    //[1,1,1,6]-->smallest cant form sum is 4
    //[1,1,3,4]-->10

    //solution 1: similar to knapsack
    public int findSmallestCantSum(int[] coins) {
        int sum = 0;
        for (int coin : coins) {
            sum += coin;
        }

        Arrays.sort(coins);
        int len = coins.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];

        for(int j=0; j<=sum;j++){
            dp[0][j] = false;

        }
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i][j] == true) {
                    continue;
                } else if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j - coins[i - 1]];
                }
            }
        }

        for (int j = 0; j <= sum; j++) {
            if (dp[len][j] == false) return j;
        }
        return sum + 1;
    }

    //solution 2: observation on dp
    public int smallestCantSum(int [] coins){
        int sum = 0;
        for (int i=0;i<coins.length;i++) {
            sum += coins[i];
            if (coins[i + 1] > sum + 1) return sum + 1;
        }

        return sum+1;
    }
}
