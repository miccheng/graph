package com.example.leetcode.arraystr;

import java.util.Arrays;

public class BestTimeBuySellStockI {
    //keep track of the previous lowest price: dp idea
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int min=prices[0];
        int max=0;
        int len=prices.length;

        for(int i=1;i<len;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        return max;
    }

}
