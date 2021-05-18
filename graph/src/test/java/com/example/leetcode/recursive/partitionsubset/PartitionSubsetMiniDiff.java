package com.example.leetcode.recursive.partitionsubset;

//    https://leetcode.com/problems/last-stone-weight-ii/
//equals to partition array into 2 subset to get the mini diff
public class PartitionSubsetMiniDiff {
  //***s1, s2--> s2=sum-s1,diff(s2,s1)=sum-s1-s1. So we just have to max s1
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int row = stones.length + 1;
        int[][] dp = new int[row][sum / 2 + 1];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (stones[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i - 1] + dp[i - 1][j - stones[i - 1]]);
            }
        }

        return sum - 2 * dp[row][sum / 2];
    }

    //recursive: targetSum is num/2. diff=sum-2*s1;
    public int partitionMiniDiffRecursiveUp(int[] nums,int index, int accumulated ,int targetSum) {
        //base case
        if (accumulated > targetSum || index >= nums.length) return accumulated;

        int stoneSet1 = partitionMiniDiffRecursiveUp(nums, index + 1, accumulated, targetSum);
        int stoneSet2 = partitionMiniDiffRecursiveUp(nums, index + 1, accumulated + nums[index], targetSum);
        int max = Math.max(stoneSet1, stoneSet2);

        return targetSum*2-2*max;
    }
}
