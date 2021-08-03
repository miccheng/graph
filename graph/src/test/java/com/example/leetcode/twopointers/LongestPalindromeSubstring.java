package com.example.leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubstring {

    //Solution 1: expand and update
    private int max=1;
    private int start=0;
    private int end=0;

    public String longestPalindromeV(String s) {
        if(s.length()==1) return s;

        for(int i=0;i<s.length();i++){
            validatePalindrome(i,i,s);// long
            validatePalindrome(i,i+1,s);//smaller
        }

        return s.substring (start,end+1);
    }


    public void validatePalindrome(int i,int j,String s){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            if(j-i+1>max){
                max=Math.max(j-i+1,max);
                start=i;
                end=j;
            }
            i--;
            j++;
        }
    }

    // Solutoion 2: using Dp
    public static String longestPalindrome2(String s) {
        if(s.length()==1) return s;
        int len=0;
        int start=0;
        int tableLen = s.length();
        boolean[][] dp = new boolean[tableLen][tableLen];
        //fill dp table with boolean(index)
        for (int i = tableLen-1; i >=0 ; i--) {
            dp[i][i] = true;
            for (int j = i ; j <= tableLen - 1; j++) {//***i==j
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == true)) {
                    dp[i][j] = true;
                }
                //***condition to update start index
                if (dp[i][j] &&j-i+1>len) {
                    len =  j - i + 1;
                    start = i;
                }
            }
        }
        int end=len+start-1;
        return s.substring(start,end+1);
    }

    public static String longestPalindrome(String s) {
      int n = s.length();
      String res = null;
      int palindromeStartsAt = 0, maxLen = 0;

      boolean[][] dp = new boolean[n][n];
      // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

      for (int i = n - 1; i >= 0; i--) { // keep increasing the possible palindrome string
          for (int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

              //check if substring between (i,j) is palindrome
              dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                      &&
                      (j - i < 3  // if window is less than or equal to 3, just end chars should match
                              || dp[i + 1][j - 1]); // if window is > 3, substring (i+1, j-1) should be palindrome too

              //update max palindrome string
              if (dp[i][j] && (j - i + 1 > maxLen)) {
                  palindromeStartsAt = i;
                  maxLen = j - i + 1;
              }
          }
      }
      return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
  }

}
