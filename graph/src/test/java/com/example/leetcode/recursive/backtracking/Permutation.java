package com.example.leetcode.recursive.backtracking;

import java.util.*;

// no duplicate scenario: mark taken element to avoid it being taken again.
// use linkedhashset to skip checking on marking
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[][] expected = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        permute(nums);
    }


    public static List<List<Integer>> permute(int[] nums) {
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        permutationRecursive(nums, result, new LinkedHashSet<Integer>());
        return result;
    }

    //use list or set to keep track of the used numbers
    private static void permutationRecursive(int[] nums, List<List<Integer>> result, Set path) {
        //base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
//            if(path.contains(nums[i])) continue;
            if (path.add(current)) {//***** use set rather than list to keep track of used ele
                permutationRecursive(nums, result, path);
                path.remove(current);
            }
        }
    }

}
