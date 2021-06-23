package com.example.leetcode.recursive.backtracking;

import java.util.*;
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//NOT unique, and can reuse element-->simple recursive, can be substitute to dp
public class CombinationSumIV {
    public static void main(String[] args) {
        int nums[]={1,2,3};
        int target = 4;

//        int arr[] = {2, 3, 6, 7};
        combinationSum(nums,target);
    }

    public static List<List<Integer>> combinationSum(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRecursive(targetSum, arr, new ArrayList<>(), result);
        return result;
    }


    private static void combinationSumRecursive( int targetSum, int[] arr, List<Integer> path, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (targetSum < 0) return;

        for (int i = 0; i < arr.length; i++) {//alternative: can set i=0 and pass the whole array in line 34(reusable)
            int current = arr[i];
            path.add(current);
            int remainder = targetSum - current;//must assign to a new variable after subtracting
            combinationSumRecursive(remainder, arr, path, result);
            path.remove(path.size() - 1);
        }
    }

    //count sum
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];

        for (int n : nums) {
            if (n <= target) dp[n] = 1;
        }

        for (int i = 0; i <= target; i++) {
            for (int n : nums) {
                if (i + n <= target) dp[i + n] = dp[i + n] + dp[i];
            }
        }
        return dp[target];
    }





}
