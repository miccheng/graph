package com.example.leetcode.gridtraveller;

import java.util.Arrays;

public class TestCherry {

    static int[][] grids = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
    static int n = grids.length;

    public static void main(String args[]) {
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.stream(a).forEach(b -> Arrays.fill(b, Integer.MIN_VALUE)));
        dp[0][0][0] = 0;
        dp[1][1][1] = grids[0][0];
//        int dpCherries = cherry(dp);
        int i = pickupCherryDp(dp);
        System.out.println(i);
    }

    public static int cherry(int[][][] dp) {
        dp[1][1][1] = grids[0][0];
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    int y2 = x1 + y1 - x2;
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grids[x1 - 1][y1 - 1] == -1 || grids[x2 - 1][y2 - 1] == -1) {
                        continue;
                        // have already detected || out of boundary || cannot access
                    }
                    int cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]), Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));
                    if (cur < 0) {
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grids[x1 - 1][y1 - 1];
                    if (x1 != x2) {
                        dp[x1][y1][x2] += grids[x2 - 1][y2 - 1];
                    }
                }
            }
        }
        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }

    private static int pickupCherryDp(int[][][] dp) {
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= n; x2++) {
                    int y2 = x1 + y1 - x2;
                    // have already detected || out of boundary || cannot access
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grids[x1 - 1][y1 - 1] == -1 || grids[x2 - 1][y2 - 1] == -1) {
                        continue;
                    }
                    int max = Math.max(
                            Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]),
                            Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));

                    if(max < 0){
                        continue;
                    }
                    if (x1 == x2) {
                        dp[x1][y1][x2] = max + grids[x1-1][y1-1];
                    } else {
                        dp[x1][y1][x2]=max+grids[x1-1][y1-1]+grids[x2-1][y2-1];
                    }
                }
            }
        }
        return dp[n][n][n];
    }

}
