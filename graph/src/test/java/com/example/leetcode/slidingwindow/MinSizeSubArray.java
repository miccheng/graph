package com.example.leetcode.slidingwindow;

public class MinSizeSubArray {
//return the minimal length of a contiguous subarray of which the sum is greater than or equal to target
    public static void main(String[] args) {
        int nums[]={2,3,1,2,4,3};
        minSubArrayLens(7,nums);

        int arr[]={2,3,1,2,4,3};
        int target=7;
        minSubArrayLen(target,arr);
    }

    public static int minSubArrayLen(int s, int[] A) {
        int i = 0, n = A.length, res = n + 1;
        for (int j = 0; j < n; ++j) {
            s -= A[j];//equivalent to accumulate num->sum, and then subtract-target
            while (s <= 0) {
                res = Math.min(res, j - i + 1);
                s += A[i++];
            }
        }
        //if there isn't any subarray, return 0;
        return res % (n + 1);
    }


    public static int minSubArrayLens(int target, int[] nums) {
        if(target==0 ||nums==null ||nums.length==0) return 0;

        int len=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int resultLen=Integer.MAX_VALUE;

        while(j<len){
            sum+=nums[j];
            j++;

            while(sum>=target){
                resultLen=Math.min(resultLen,j-i);
                sum-=nums[i];
                i++;
            }

        }

        return resultLen==Integer.MAX_VALUE?0:resultLen;
    }
}
