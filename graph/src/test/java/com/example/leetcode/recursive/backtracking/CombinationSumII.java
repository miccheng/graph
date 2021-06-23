package com.example.leetcode.recursive.backtracking;

//unique
//can't reuse element && have duplicate ele
//Input: candidates = [2,5,2,1,2], target = 5
//        Output:
//        [
//        [1,2,2],
//        [5]
//        ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        allSubset(candidates, target, 0, 0, path, result);
        return result;
    }

    private void allSubset(int[] nums, int target, int sum, int index, List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            int total = sum + nums[i];
            allSubset(nums, target, total, i + 1, path, result);//i + 1
            path.remove(path.size() - 1);
        }

    }

}
