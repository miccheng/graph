package com.example.leetcode.recursivedp;

public class IsSubsequence {
    //***follow up question:NumberOfMatchingSubsequences
//        String s = "abc";
//        String t = "ahbgdc";

    //Solution 1: 2pointers: exam each character in s exist in t or not
    // Follow up:  s = "abcde", words = ["a","bb","acd","ace"], how many in the list is s's subsequence

    //Solution 2: dp similar to LCSubsequence
    public static boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0) return true;
        if(t==null|| t.length()==0) return false;

        int len1=s.length();
        int len2=t.length();
        int [][]dp=new int [len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[len1][len2]==len1;
    }
}
