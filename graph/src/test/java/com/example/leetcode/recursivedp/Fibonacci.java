package com.example.leetcode.recursivedp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        int result = topDown(5, map);
        System.out.println(result);


        bottomUp(10);
    }

    private static int topDown(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n) == false) {
            int val=topDown(n - 1, map) + topDown(n - 2, map);
            map.put(n,val);
            return val;
        }
        return map.get(n);
    }

    private static int bottomUp(int n) {
        int previous =1;
        int current = 2;
        if (n <= 2)
            return n;
        else
            for (int i =3; i <=n ; i++) {
                int node = previous + current;
                previous = current;
                current=node;

            }
        System.out.println(current);
        return current;
    }

    private static int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
