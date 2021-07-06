package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.Arrays;

public class RussianDoll {
    public static void main(String[] args) {
        int arr[][]={{77,81},{72,45},{52,68},{50,53}, {46,89}};
        maxEnvelopes(arr);
    }


    private static int laymax=Integer.MIN_VALUE;
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null | envelopes.length==0) return 0;

        int len=envelopes.length;
        Arrays.sort(envelopes, (a, b)->b[0]-a[0]);
        int max=Integer.MIN_VALUE;

        for(int i=0;i<len;i++){
            int begcount=1;
            recurisve(i, envelopes, len, begcount);
            max=Math.max(laymax,max);
        }
        return max;

    }

    public static void recurisve(int start,int[][] envelopes, int len, int count){
        if(start==len-1) {
            laymax=Math.max(laymax,count);
            return ;
        }

        for(int i=start+1; i<len;i++){
            if(envelopes[start][0]>envelopes[i][0]&&envelopes[start][1]>envelopes[i][1]){
                recurisve(i, envelopes, len,count+1);
            }
        }
        laymax=Math.max(laymax,count);
    }
}
