package com.example.leetcode.arraystr;
//    Kadane's algo
public class MaxSumArray {
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(arr);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentMax < 0) {
                currentMax = nums[i];
            } else {
                currentMax += nums[i];
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }


   public int findMaxSumArray(int [] arr) {
       int max = arr[0];
       int currentMax = max;
       for (int i = 0; i < arr.length; i++) {
           currentMax = Math.max(max + arr[i], max);//stand alone or to be appended
           max = Math.max(currentMax, max);
       }

       return max;
   }
}
