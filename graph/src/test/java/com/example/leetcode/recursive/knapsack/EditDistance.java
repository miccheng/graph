package com.example.leetcode.recursive.knapsack;

public class EditDistance {
    //variation: One edit distance

    //starting from recursive
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        return recursive(0, word1, 0, word2);
    }

    public int recursive(int i, String word1, int j, String word2) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        int operation = Integer.MAX_VALUE;
        if (word1.charAt(i) == word2.charAt(j)) {
            int oper1 = recursive(i + 1, word1, j + 1, word2);
            operation = Math.min(oper1, operation);
        } else {
            int delete = recursive(i + 1, word1, j, word2);
            int insert = recursive(i, word1, j + 1, word2);
            int replace = recursive(i + 1, word1, j + 1, word2);
            operation = Math.min(Math.min(delete, insert), replace) + 1;
        }

        return operation;
    }

    //Solution2: after realising the key for memo map is index of word1 and word2. we flip it into iterative
    public int minDistanceDP(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


}
