package com.example.leetcode.array;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int arr[] = {3, 4, -1, 1};
    }

    //Identify the problem:the 1st missing positive falls into [1,len+1]
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //step1: check original 1 && flip negative num and num>k to 1
        int contains0 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                contains0 = 1;
            } else if (nums[i] > len || nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        if (contains0 == 0) return 1;//***boundary check

        //step2: use num as index.
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -1 * nums[index];
        }

        //step3: find the positive num. Its index is never touched->its missing in the arr
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return i + 1;
        }

        //[1,2,3]->4
        return len + 1;//***special case
    }
}
