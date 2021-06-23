package com.example.leetcode.recursive.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {

    public static void main(String[] args) {
        int[] nums={1,2,2};
        subsets(nums);
    }
    //subset set without duplicate
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);//must sort first, otherwise duplicate subset will be counted
        generateSub(0,nums, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generateSub(int start,int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {
        //base case
        result.add(new ArrayList<>(path));

        for (int j = start; j < nums.length; j++) {
            if (j > start && nums[j] == nums[j - 1]) continue; // arrays must be sorted ahead
            path.add(nums[j]);
            generateSub(j + 1, nums, path, result);
            path.remove(path.size() - 1);
        }

    }

    //subset with duplicate
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

}
