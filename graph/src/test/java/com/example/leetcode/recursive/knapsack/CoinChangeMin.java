package com.example.leetcode.recursive.knapsack;

import java.util.Arrays;

public class CoinChangeMin {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        coinChange(arr, 11);
    }

    //Solution1: 1d array
    public int coinChangeM(int[] coins, int amount) {
        int len = coins.length;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        Arrays.sort(coins);
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] != Integer.MAX_VALUE ? 1 + dp[i - coin] : Integer.MAX_VALUE);
                else
                    break;
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    //Solution2:2d array
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                int tmp = (coins[i - 1] <= j && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) ? dp[i][j - coins[i - 1]] + 1 : Integer.MAX_VALUE;
                dp[i][j] = Math.min(tmp, dp[i - 1][j]);
            }
        }
        return dp[len][amount] == Integer.MAX_VALUE ? -1 : dp[len][amount];
    }


}
