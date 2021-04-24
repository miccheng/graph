package com.example.leetcode.recursive.partitionsubset;

public class PartitionSubsetEqual {
    //A variation of 0/1 knapsack problem && subset problem. Take mean it goes into s1, else it goes s2
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if((sum & 1) == 1)  return false;//sum%2==0

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {//initialize rows with true
            dp[i][0]=true;
        }

        for (int j = 1; j < sum+1; j++) {//initialize columns with false
            dp[0][j]=false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);//compare to coin change problem
                }
            }
        }
        return dp[n][sum];
    }


// index: which ele in the array to be decide to take or not. targetSum is the total of array/2.
    public boolean canPartitionRecursive(int[] nums,int index, int targetSum) {
        //base case
        if (targetSum == 0) return true;
        if (index >= nums.length || targetSum < 0) return false;

        //take
        boolean b = canPartitionRecursive(nums, index + 1, targetSum - nums[index]);
        //not to take
        boolean d = canPartitionRecursive(nums, index + 1, targetSum);
        return b || d;

    }

    public boolean canPartitionRecursiveUp(int[] nums,int index, int accumulated ,int targetSum) {
        //base case
        if (accumulated == targetSum) return true;
        if (accumulated > targetSum || index >= nums.length) return false;

        boolean b = canPartitionRecursiveUp(nums, index + 1, accumulated, targetSum);
        boolean d = canPartitionRecursiveUp(nums, index + 1, accumulated + nums[index], targetSum);
        return b || d;
    }
}
