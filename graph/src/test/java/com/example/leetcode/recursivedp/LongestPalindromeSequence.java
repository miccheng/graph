package com.example.leetcode.recursivedp;

//Idea:chopping character off. Similar to edit distance. remove, replace, insert operation
//***dp table: Known as LPS, SIMILAR to Longest Palindrome Substring, but DIFF from LCS table( Longest Common Sequence).
//***Sliding window with expanding length-->Table in reversed order.  bottom->up , left->right
//****Table size equals to string.length, initialize diagonal first
public class LongestPalindromeSequence {
    public static void main(String args[]) {
        String s = "bbbab";//result bbbb
        longestPalindromeSubseq(s);
    }

// table index meaning: i=start index, j=end index
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;//***initialize diagonal
            for (int j = i + 1; j < len; j++) {//***j=i+1. j<len
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
