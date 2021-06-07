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

    private static void generateSub(int index,int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {
        //base case
        result.add(new ArrayList<>(path));

        for (int j = index; j < nums.length; j++) {
            if (j > index && nums[j] == nums[j - 1]) continue; // skip duplicates on the condition of nums is sorted
            path.add(nums[j]);
            generateSub(j + 1, nums, path, result);
            path.remove(path.size() - 1);
        }

    }

    //subset with duplicate


}
