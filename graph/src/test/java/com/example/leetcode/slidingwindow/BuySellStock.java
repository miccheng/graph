package com.example.leetcode.slidingwindow;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 0;
        int maxProfit = 0;
        while (j < prices.length) {
            if (prices[i] < prices[j])
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            else
                i = j;
            j++;
        }
        return maxProfit;
    }
}
