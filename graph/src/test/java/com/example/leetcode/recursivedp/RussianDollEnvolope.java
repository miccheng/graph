package com.example.leetcode.recursivedp;

import java.util.Arrays;

public class RussianDollEnvolope {

    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null | envelopes.length==0) return 0;

        int len=envelopes.length;
        Arrays.sort(envelopes, (a, b)->b[0]-a[0]);
        int max=Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            int layers= recursive(i, envelopes, len);
            max=Math.max(layers,max);
        }
        return max+1;

    }

    public static int recursive(int start, int[][] envelopes, int len){
        if(start>=len-1) {
            return 0;
        }
        int layerMax=0;
        for(int i=start+1;i<len;i++){
            if(envelopes[i][0]<envelopes[start][0]&&envelopes[i][1]<envelopes[start][1]){
                layerMax=Math.max(layerMax, recursive(i,envelopes,len)+1);
            }
        }

        return layerMax;
    }


    //Solution 2: equals to LIS problem
    public int maxEnvelopesDP(int[][] envelopes) {
        if(envelopes==null | envelopes.length==0) return 0;

        Arrays.sort(envelopes, (a, b)->b[0]-a[0]);

        int len=envelopes.length;
        int[] dp=new int[len];
        Arrays.fill(dp,1);

        int max=1;

        for(int i=len-1; i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }

        for(int n: dp){
            max=Math.max(n,max);
        }
        return max;
    }
}
