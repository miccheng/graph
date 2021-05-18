package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/increasing-subsequences/
//diff from subset problem, it can't be sorted so nums[i]==nums[i-1] won't work. Have to use hashset.
public class IncreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequencesRecursive(nums,0,new ArrayList<Integer>(),result);
        return result;
    }

    private void findSubsequencesRecursive(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        if (path.size() > 1) result.add(new ArrayList<>(path));
        Set<Integer> visited = new HashSet();

        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) continue;
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                visited.add(nums[i]);
                path.add(nums[i]);
                findSubsequencesRecursive(nums, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
