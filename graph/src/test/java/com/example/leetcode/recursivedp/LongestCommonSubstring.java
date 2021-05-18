package com.example.leetcode.recursivedp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "bc";
        String s2 = "abcde";
        LCS(s1, s2);
    }

    private static int LCS(String s1, String s2) {
        int max = 0;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

}
