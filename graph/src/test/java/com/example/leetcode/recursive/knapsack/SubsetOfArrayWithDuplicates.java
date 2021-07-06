package com.example.leetcode.recursive.knapsack;

import java.util.*;

// Diff from regular subset problem. See all substring subset which Used backtracking, this used knapsack idea
// Also look at permutation && combination problem for backtracking
public class SubsetOfArrayWithDuplicates {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3};
        subsetsWithDup(arr);
    }

    //****how to avoid duplicate num?
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int index = 0;
        allSubset(nums, index, path, result);
        return result;
    }

    private static void allSubset(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        //base case
        if (index >= nums.length) {
            result.add(new ArrayList<>(path));//****must new array to wrap path instead of using path directly
            return;
        }

        //take
        path.add(nums[index]);
        allSubset(nums, index + 1, path, result);

        path.remove(path.size() - 1);

        //repeated value, so don't need to proceed.
        if (index > 0
                && path.size() > 0
                && nums[index] == path.get(path.size() - 1)) {
            return;
        }

        allSubset(nums, index + 1, path, result);

    }


    private static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> findSubsequencesII(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private static void helper(int[] nums, int index, List<Integer> ans) {
        if (index > nums.length - 1) {
            if (ans.size() > 1) result.add(new ArrayList<>(ans));
            return;
        }

        //increasing subarray
        if (ans.isEmpty() || nums[index] >= ans.get(ans.size() - 1)) {
            ans.add(nums[index]);
            helper(nums, index + 1, ans);
            ans.remove(ans.size() - 1);
        }

        // repeated value, so don't need to drill down.
        if (index > 0
                && ans.size() > 0
                && nums[index] == ans.get(ans.size() - 1)) {
            return;
        }
        helper(nums, index + 1, ans);
    }


}
