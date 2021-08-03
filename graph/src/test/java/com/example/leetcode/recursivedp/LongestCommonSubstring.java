package com.example.leetcode.recursivedp;

//The difference between LongestCommonSubsequence is that
// when s1.charAt(i - 1) != s2.charAt(j - 1),levae dp[i][j]=0;
public class LongestCommonSubstring {
    public static void main(String[] args) {
        divisorGame(5);
        String s2 = "ABCDGH";
        String s1 = "ACDGHR";
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

    //recursive approach
    public static int LCSubStrM1(char[] X, char[] Y, int m, int n, int lcsCount) {
        if (m <= 0 || n <= 0)
            return lcsCount;

        int lcsCount1=lcsCount;
        if (X[m - 1] == Y[n - 1])
            lcsCount1 = LCSubStrM1(X, Y, m - 1, n - 1, lcsCount + 1);

        int lcsCount2 = LCSubStrM1(X, Y, m, n - 1, 0);
        int lcsCount3 = LCSubStrM1(X, Y, m - 1, n, 0);

        return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
    }



    public static boolean divisorGame(int n) {
        return recursive(n);
    }

    public static boolean recursive(int n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (recursive(n - i) == true) return true;
            }
        }

        return true;
    }

}
