package com.example.leetcode.recursive.knapsack;

public class TargetSum {
    //leetcode 494. Target Sum
//    ** similar to subset sum, but different, as there might be 0(non negative numbers instead of all positive)
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int len = nums.length;

        int count = 0;
        for (int n : nums) {
            sum += n;
            if (n == 0) count++;
        }

        int twiceS1 = (sum + target);
        if (twiceS1 % 2 != 0) return 0;

        int[][] dp = new int[len + 1][twiceS1 / 2 + 1];


        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= twiceS1 / 2; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }

        return dp[len][twiceS1 / 2];
    }
}
