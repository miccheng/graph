package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerfectSquareNumbers {
    public static void main(String[] args) {
        numSquaresDp(13);
        System.out.println();
    }

    public  int numSquares(int n) {
        if (n == 0 || n == 1) return n;
        return recursive(n,  new HashMap<Integer, Integer>());

    }

    public  int recursive(int n, Map<Integer, Integer> map) {
        if (n == 0) return 0;
        if(map.containsKey(n)) return map.get(n);

        int min=Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = 1 + recursive(n - i * i,map);
            min = Math.min(min, result);
        }
        map.put(n,min);
        return min;
    }

//    public int recursive(int n, int min){
//        if(n==0) return 0;
//
//        int i=1;
//        List <Integer> perfecrSquare=new ArrayList<>();
//        while(i*i<=n){
//            perfecrSquare.add(i*i);
//            i++;
//        }
//
//        for(int perfect: perfecrSquare){
//            if(perfect<=n){
//                int result=1+recursive(n-perfect, min);
//                min=Math.min(min,result);
//            }
//
//        }

    public static int numSquaresDp(int n) {
        if (n == 0 || n == 1) return n;

        int start = 1;
        while (start * start <= n) {
            start++;
        }

        int dp[][] = new int[start][n + 1];

        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <start ; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * i == j) {
                    dp[i][j] = 1;
                } else if (j < i * i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - i * i], dp[i - 1][j]);
                }
            }
        }
        return dp[start][n];
    }

}