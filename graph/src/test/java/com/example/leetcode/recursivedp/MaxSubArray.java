package com.example.leetcode.recursivedp;

//similar to max product subarray && longest Increasing subsequence
public class MaxSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, 2, 5, -11, 6};
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
