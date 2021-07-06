package com.example.leetcode.binarysearch;

public class SearchInRotatedArray {

    public static int search(int[] nums, int target) {
        int pivot=findPivot(nums);
        return search(pivot,nums, target);
    }

    public static int findPivot(int[] nums){
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }



    public static int search(int pivot,int nums[], int target){
        int left=0;
        int right=nums.length-1;

        if(target>=nums[pivot]&& target<=nums[nums.length-1]){
            left=pivot;
        }else{
            right=pivot;
        }

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
