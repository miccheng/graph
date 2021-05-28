package com.example.leetcode.arraystr;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
public class AllDuplicateNum {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(nums);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(n));//
                continue;
            }
            nums[index] = -1 * nums[index];
        }
        return result;
    }
}
