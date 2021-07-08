package com.example.leetcode.recursive.knapsack;

public class CuttingRod {
    public static void main(String[] args) {
        int profit[]={1,5,8,9,10,17,18};
        int max=cutRod(profit,7);
        dpCutRod(profit,7);
        System.out.println(max);
    }

    //Solution 1: DFS
    public static int cutRod(int profit[], int rod) {
        if (rod == 0) return 0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < profit.length; i++) {
            int remain = rod - (i+1);
            if (remain >= 0) {
                int pr = cutRod(profit, remain);
                max = Math.max(max, pr + profit[i]);
            }
        }
        return max;
    }

    //Solution 2: dp
    public  static  int dpCutRod(int profit[], int rod) {
        int dp[] = new int[rod + 1];
        dp[0] = 0;

        for(int i = 1; i <= rod; i++){
            dp[i]=Integer.MIN_VALUE;
        }

        for (int i = 1; i <= rod; i++) {
            for (int j = 0; j < profit.length; j++) {
                if (i >= j + 1) dp[i] = Math.max(dp[i], profit[j] + dp[i - (j + 1)]);
            }
        }

        return dp[rod];
    }

}
