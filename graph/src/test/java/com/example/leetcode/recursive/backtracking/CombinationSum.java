package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//can reuse element
public class CombinationSum {
    public static void main(String[] args) {
        int arr[]={1,2,2,2,5};
//        int targetSum = 5;

//        int arr[] = {2, 3, 6, 7};
        int targetSum = 7;
    }

    public static List<List<Integer>> combinationSum(int[] arr, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRecursive(0, targetSum, arr, new ArrayList<>(), result);
        return result;
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
            int remainder = targetSum - current;//must assign to a new variable after subtracting
            combinationSumRecursive(i, remainder, arr, path, result);
            path.remove(path.size() - 1);
        }
    }


//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        int index = 0;
//        Arrays.sort(candidates);
//        allSubset(candidates, target, index, path, result);
//        return result;
//    }
//
//    private static void allSubset(int[] nums,int target, int index, List<Integer> path, List<List<Integer>> result) {
//        //base case
//        if (target == 0) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        if (target < 0 || index >= nums.length) return;
//
//        //take
//        path.add(nums[index]);
//        allSubset(nums, target-nums[index] ,index+1, path, result);
//
//
//        path.remove(path.size() - 1);
//
//        //repeated value, so don't need to proceed.
//        if (index > 0
//                && path.size() > 0
//                && nums[index] == path.get(path.size() - 1)) {
//            return;
//        }
//
//        allSubset(nums, target, index + 1, path, result);
//
//    }

}
