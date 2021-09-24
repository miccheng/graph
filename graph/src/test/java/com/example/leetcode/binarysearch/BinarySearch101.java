package com.example.leetcode.binarysearch;

public class BinarySearch101 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search2 (int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target ? lo : -1;
    };

    //find leftmost minimal(include current)
//    if(<=)
//        right=mid
//return left;

    //find rightmost maximal(exclude current)
//    if(<=)
//        left=mid+1
// return left-1;
}
