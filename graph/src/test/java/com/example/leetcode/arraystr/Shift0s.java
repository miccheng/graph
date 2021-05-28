package com.example.leetcode.arraystr;

public class Shift0s {
    //shift all zeros to left and return the number of non zero elements O(n)time&O(1)space
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
    }

    //solution 1: reserve all the non-zero nums and fit the rest with 0 at last
    //shift 0s to all the right
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        //****fit all the rest with 0s
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    //solution 2: swap with 2 pointers. Similar idea
    public void swapZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int anchor=0;
        for (int i=0;i< nums.length;i++) {
            if(nums[i]!=0){
                nums[anchor++]=nums[i];
                nums[i] = 0;
            }
        }
    }

}
