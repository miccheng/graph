package com.example.leetcode.rotate;

import java.util.Arrays;

public class NextPermutation {
    //[9,1,2,4,3,1,0]-->[9,1,3,0,1,2,4]
    public static void main(String[] args) {
//        int arr[]={9,1,2,4,3,1,0};
        int arr[]={1,4,2,3};
        findNextPermutation(arr);
    }

    public static void findNextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        //find the reverse point index
        int k = nums.length - 2;
        while (k >= 0) {
            if (nums[k] < nums[k + 1]) break;
            k--;
        }
        //*** special case when it's already the last permutation,reverse the whole string
        if (k < 0) {
            Arrays.sort(nums);
            return;
        }

        //get smallest number of the traversed numbers that is larger than kth
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = nums.length-1; i >k ; i--) {
            if (nums[i] > nums[k]) {
                index = i;
                break;
            }
        }
        //swap the numbers
        swap(k, index, nums);

        //it was descending, reverse into ascending order from index+1
        reverse(nums, k+1, nums.length-1);
        System.out.println();
    }

    private static void reverse(int[] nums, int start, int tail) {
        while (tail < nums.length &&start<tail) {
            swap(start, tail, nums);
            tail--;
            start++;
        }
    }

    private static void swap(int start, int index, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;
    }
}
