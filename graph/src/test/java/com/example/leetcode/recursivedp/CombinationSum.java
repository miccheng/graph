package com.example.leetcode.recursivedp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int targetSum = 7;
        int arr[] = {2, 3, 6, 7};
        combinationSum(arr, targetSum);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRecursive(0, target, candidates, new ArrayList<>(), result);
        return null;
    }

    private static void combinationSumRecursive(int index, int targetSum, int[] arr, List<Integer> path, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (targetSum < 0) return;
        for (int i = index; i < arr.length; i++) {
            int current = arr[i];
            path.add(current);
            int remainder = targetSum - current;
            combinationSumRecursive(index, remainder, arr, path, result);
            path.remove(path.size() - 1);
        }
    }


    public static List<List<Integer>> combinationSumR(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
