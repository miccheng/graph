package com.example.leetcode.slidingwindow;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return 0;

        int len = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int product[] = new int[len];
        while (j < len) {
            product[j] = (j == 0 ? 1 : product[j - 1]) * nums[j];

            while (i <= j && product[j] >= k) {
                product[j] /= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}
