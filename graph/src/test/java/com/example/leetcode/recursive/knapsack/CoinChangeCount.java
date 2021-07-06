package com.example.leetcode.recursive.knapsack;

public class CoinChangeCount {
    //essentially, it is an unbounded knapsack problem--> bounded knapsack: partition equal subset

    //how many ways to form it? count
    //unbounded knapsack
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

//the minimum way to form it?
    //recursive: min(1+count(coins, amount-coin[i],i),count(coins,amount,i+1))
    //if(amount>0&& no coins return INF)
    //if(amount==0) return 0;



    //dp solution:
    //dp[i][j]=min(dp[i-1][j], dp[i][j-nums[i-1]]) either exclude the current coin, or include.
    // dp[i][j-nums[i-1]] instead of dp[i-1][j-nums[i-1]] cos you have unlimited number of the coins.
    //if j< coins[i-1], include option doesn't have to be considered at all
}
