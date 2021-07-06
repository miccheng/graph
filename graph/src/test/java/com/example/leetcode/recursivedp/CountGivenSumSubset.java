package com.example.leetcode.recursivedp;

import java.util.HashMap;
import java.util.Map;

public class CountGivenSumSubset {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        countGivenSumSubset(nums, 5);
        countGivenSumSubsetKnapsack(0, nums, 5, new HashMap<String, Integer>());

        countGivenSumSubsetBacktrack(0, nums, 5);
    }

    //Count of subsets with a given sum
    //Solution 1:
    public static int countGivenSumSubset(int nums[], int target) {
        if (nums == null || nums.length == 0) return 0;
        int len=nums.length;
        int [][] dp=new int[len+1][target+1];

        for (int j = 0; j <=target ; j++) {
            dp[0][j]=0;
        }

        for (int i = 0; i <=len ; i++) {
            dp[i][0]=1;
        }

        for(int i=1;i<=len;i++){
            for (int j = 1; j <=target ; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }

        return dp[len][target];
    }


    //Solution 3:
    private static int counter=0;
    public static int countGivenSumSubsetKnapsack(int start, int nums[], int target, Map<String, Integer> map) {
        if (target == 0) return 1;
        if (start >= nums.length || target < 0) return 0;

        String key = String.valueOf(start) + ":" + String.valueOf(target);
        if (map.containsKey(key)) return map.get(key);

        int ways = countGivenSumSubsetKnapsack(start + 1, nums, target - nums[start], map) + countGivenSumSubsetKnapsack(start + 1, nums, target, map);
        map.put(key, ways);
        return ways;
    }

    //Solution 2:
    private static int count=0;
    public static void countGivenSumSubsetBacktrack(int start, int nums[], int target) {
        if (target == 0) count++;

        for (int i = start; i < nums.length; i++) {
            int current = nums[i];
            int remain = target - current;
            countGivenSumSubsetBacktrack(i + 1, nums, remain);
        }
    }

}
