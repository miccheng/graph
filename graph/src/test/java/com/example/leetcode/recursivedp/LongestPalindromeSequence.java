package com.example.leetcode.recursivedp;

//Idea:chopping character off. Similar to edit distance. remove, replace, insert operation
//***dp table: Known as LPS, SIMILAR to Longest Palindrome Substring, but DIFF from LCS table( Longest Common Sequence).
//***Table in reversed order.  bottom->up , left->right
//****Table size equals to string.length, initialize diagonal first
public class LongestPalindromeSequence {
    public static void main(String args[]) {
        String s = "aebba";//result bbbb
        longestPalindromeSubseq(s);
    }

    // table index meaning: i=start index, j=end index
    //Solution 1:
    //thinking from recursive to dp: build from small string from the back. What is the LPS for a,ba,bba, ebba
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

    //solution 2: build from the same length.
    //Sliding window with expanding length from 1,2,3,4
    public static int longestPalindromeSubsequence(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int expandingLen = 1; expandingLen <= len; expandingLen++) {
            for (int i = 0; i + expandingLen < len; i++) {
                int j = i + expandingLen - 1;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
