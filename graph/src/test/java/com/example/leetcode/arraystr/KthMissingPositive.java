package com.example.leetcode.arraystr;

public class KthMissingPositive {
    public static void main(String[] args) {
        int []nums={2,3,4,7,11};
        findKthPositive(nums,5);
    }

    //find the nearest equal(leftmost) or greater value to k. ceiling values
    public static int findKthPositive(int[] arr, int k) {
        if(arr==null) return 0;
        if(k<arr[0]) return k;

        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=left + (right-left)/2;
            if(arr[mid]-(mid+1)<k){
                left=mid+1;
            }else{//>=k
                right=mid-1;
            }
        }

        return left+k;
    }
}
