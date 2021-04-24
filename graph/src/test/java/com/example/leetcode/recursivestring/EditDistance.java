package com.example.leetcode.recursivestring;

public class EditDistance {
    public static void main(String args[]) {
        String provided = "horse";
        String target = "ros";

        minDistance(provided, target);
    }

    public static int minDistance(String provided, String target) {
        int column = target.length();
        int row = provided.length();
        int[][] dp = new int[row + 1][column + 1];
        //fill row 0
        for (int j = 0; j <= column; j++) {
            dp[0][j] = j;
        }
        //fill column 0
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (provided.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[row][column];
    }
}