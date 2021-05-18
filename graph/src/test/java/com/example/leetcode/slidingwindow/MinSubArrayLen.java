package com.example.leetcode.slidingwindow;

public class MinSubArrayLen {
//return the minimal length of a contiguous subarray of which the sum is greater than or equal to target
    public static void main(String[] args) {
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

}
