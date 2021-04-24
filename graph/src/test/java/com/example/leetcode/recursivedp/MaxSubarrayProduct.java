package com.example.leetcode.recursivedp;

public class MaxSubarrayProduct {
   public int maxProduct(int dp[], int n) {
        int result = dp[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number dp[i]
        for (int i = 1, imax = result, imin = result; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (dp[i] < 0)
                swap(imax, imin);

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(dp[i], imax * dp[i]);
            imin = Math.min(dp[i], imin * dp[i]);

            // the newly computed max value is a candidate for our global result
            result = Math.max(result, imax);
        }
        return result;
    }

    public void swap(int imax, int imin){
       
    }
}
