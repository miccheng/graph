package com.example.leetcode.binarysearch;

public class KthMissingPositive {
    public static void main(String[] args) {
        int []nums={1,2,3,4};
        findKthPositive(nums,2);
    }

    //find the value just greater(equals) value to k. ceiling values
    public static int findKthPositive(int[] arr, int k) {
        if(arr==null) return 0;
        if(k<arr[0]) return k;

        int left=0;
        int right=arr.length-1;

        while(left<right){
            int mid=left + (right-left)/2;
            if(arr[mid]-(mid+1)<k){
                left=mid+1;
            }else{//>=k
                right=mid;
            }
        }
        if(arr[left]-(left+1)<k) return left+1+k;//arr[left]+ k-(arr[left]-left-1);
        return left+k;
    }
}
