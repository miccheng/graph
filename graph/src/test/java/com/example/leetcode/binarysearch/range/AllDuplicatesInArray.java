package com.example.leetcode.binarysearch.range;

import java.util.ArrayList;
import java.util.List;
//Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears once or twice, return an array of all the integers that appears twice.
public class AllDuplicatesInArray {
    //IDEA: duplicate will be pointed to the same index. Therefore, that index will be access >1 time.
    //use the numbers as index
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) result.add(index + 1);
            nums[index] = -nums[index];
        }
        return result;
    }
}
