package com.example.leetcode.binarysearch;

public class FindMinimumInRotatedSortedArray {
    //[3,4,5,1,2]
    public static void main(String args[]){
        int []nums = {3,4,5,1,2};
        int index = findMini(nums,0, nums.length-1);
    }

    private static int findMini(int[] nums, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
