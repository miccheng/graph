package com.example.leetcode.twopointers;

public class MovingZeros {
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (nums[i] == 0 && i < nums.length && j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j = i + 1;
            } else {
                j++;
            }
        }
    }
}
