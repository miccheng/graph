package com.example.leetcode.recursivedp;

public class MinDeletionInsertionStr2Str1 {
//    Minimum deletion & insertion to transform a string into another
public static int minOperations(String str1, String str2) {
    if (str1 == null || str2 == null) return 0;
    if (str1.length() == 0) return str2.length();
    if (str2.length() == 0) return str1.length();

    int len1 = str1.length();
    int len2 = str2.length();

    int dp[][] = new int[len1 + 1][len2 + 1];

    for (int i = len1 - 1; i >= 0; i--) {
        for (int j = len2 - 1; j >= 0; j--) {
            if (str1.charAt(i) == str2.charAt(j)) {
                dp[i][j] = 2 + dp[i + 1][j + 1];
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }

    int longest = dp[0][0];
    int deletion = len1 - longest;
    int insertion = len2 - longest;
    return insertion + deletion;
}
}
