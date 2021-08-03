package com.example.leetcode.binarysearch;

public class FirstLastPositionofElementInSortedArray {
    //left most ele and right most ele
    public static void main(String args[]) {
        int target = 8;
        int arr[] = {5, 7, 7, 7, 8, 8, 8, 10};
    }

    //solution 1: plug in == and keep updating the index till left/right most
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirstEle(nums, target);
        if (firstIndex == -1) return new int[]{-1, -1};

        int lastIndex = findLastEle(nums, target, firstIndex);
        return new int[]{firstIndex, lastIndex};
    }

    private int findFirstEle(int[] nums, int target){
        int firstIndex=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=target){
                if(nums[mid]==target) firstIndex=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return firstIndex;
    }

    private int findLastEle(int[] nums, int target, int firstIndex ){
        int lastIndex=firstIndex;
        int left=firstIndex;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                if(nums[mid]==target) lastIndex=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return lastIndex;
    }

    //solution 2:
    public int[] searchRangeV2(int[] nums, int target) {
        if(nums==null|| nums.length==0) return new int []{-1,-1};


        int first=findLeftMost(nums, target);
        //****must check whether it is out of bound and whether it equals to the target value
        first=(first<nums.length&&nums[first]==target)?first:-1;

        if(first==-1) return new int []{-1,-1};

        int last=first;
        last=findRightMost(first,nums, target);
        return new int []{first,last};
    }


    private int findLeftMost(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else{//>=
                right=mid-1;
            }
        }

        return left;
    }

    private int findRightMost(int first,int[] nums, int target){
        int left=first;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
}