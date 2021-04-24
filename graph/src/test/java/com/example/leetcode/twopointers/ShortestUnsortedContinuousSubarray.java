package com.example.leetcode.twopointers;

//distribute candy
public class ShortestUnsortedContinuousSubarray {
//   Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray
//   in ascending order, then the whole array will be sorted in ascending order.
    public static void main(String args[]) {
        int arr[] = {2, 6, 4, 8, 10, 9, 15};
        findUnsortedSubarray(arr);
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0 || nums.length == 1) return 0;

        int max = Integer.MIN_VALUE;
        int end = -2;
        //iterate from beginning of array
        //find the last element which is smaller than the last seen max from
        //its left side and mark it as end
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                end = i;
        }

        int min = Integer.MAX_VALUE;
        int begin = -1;
        //iterate from end of array
        //find the last element which is bigger than the last seen min from
        //its right side and mark it as begin
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                begin = i;
        }

        return end - begin + 1;
    }


    public static int findUnsortedSubarraySimplified(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int start = -1, end = -1;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]); //from left to right, search the current max
            min = Math.min(min, nums[len - i - 1]);  //from right to left, search the current min

            if (nums[i] < max)
                end = i;
            if (nums[len - i - 1] > min)
                start = len - i - 1;
        }

        if (start == -1) //the entire array is already sorted
            return 0;

        return end - start + 1;
    }
}
