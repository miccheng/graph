package com.example.leetcode.gridtraveller;

import java.util.Arrays;

public class CherryPick {
    static int [][] grids={{0,1,-1},{1,0,-1},{1,1,1}};
    static int n=grids.length;

    public static void main(String args[]) {
//        int cherries1 = pickupCherries(0, 0, 0);
//        System.out.println(cherries1);

        int[][][] dp = new int[n+1][n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.stream(a).forEach(b->Arrays.fill(b,Integer.MIN_VALUE)));
        dp[0][0][0]=0;
        dp[1][1][1]=grids[0][0];
        int dpCherries = pickupCherryDp(dp);
        System.out.println(dpCherries);
    }

    public static int pickupCherries(int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        int cherries=0;

        //hit boundary
        if (x1 > n - 1 || y1 > n - 1 || x2 > n - 1 || y2 > n - 1 ||grids[x1][y1]==-1 || grids[x2][y2]==-1) {
            return Integer.MIN_VALUE;
        }

        //base case
        if (x1 == n - 1 && y1 == n - 1) {
            return grids[x1][y1];
        }
        if ((x2 == n - 1 && y2 == n - 1)) {
            return grids[x2][y2];
        }

        cherries += Math.max(Math.max(pickupCherries(x1 +1, y1, x2 + 1), pickupCherries(x1 + 1, y1, x2)),
                Math.max(pickupCherries(x1, y1 + 1, x2), pickupCherries(x1, y1 + 1, x2 + 1)));

        if(cherries<0)
            return -1;

        cherries += grids[x1][y1];
        if (x1 == x2 && y1 == y2) {
            return cherries;
        }
        cherries+=grids[x2][y2];
        return cherries;
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
                        dp[x1][y1][x2]+=grids[x2-1][y2-1];
                    }
                }
            }
        }
        return dp[n][n][n];
    }



}
