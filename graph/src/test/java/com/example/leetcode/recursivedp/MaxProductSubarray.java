package com.example.leetcode.recursivedp;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//*****Kadane's Algorithm
public class MaxProductSubarray {
    public static void main(String[] args) {
        int arr[] = {3,-2,4,5};
        maxProduct(arr);
    }

    //keep track of both min and max
    public static int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int result = IntStream.of(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = 1;
                min = 1;
                continue;
            }
            int tempMax = max;
            int tempMin = min;
            max = Math.max(tempMax * nums[i], tempMin * nums[i]);
            max = Math.max(max, nums[i]);

            min = Math.min(tempMax * nums[i], tempMin * nums[i]);
            min = Math.min(min, nums[i]);

            result = Math.max(result, max);
        }

        return result;
    }
}
