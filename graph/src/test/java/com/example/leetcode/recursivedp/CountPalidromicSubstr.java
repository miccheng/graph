package com.example.leetcode.recursivedp;

public class CountPalidromicSubstr {
    public int countSubstrings(String s) {
        if(s==null| s.length()==0) return 0;
        int len=s.length();

        int dp[][]=new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)&&(dp[i+1][j-1]==1||i+1>j-1)){
                    dp[i][j]=1;
                }
            }
        }
        int count=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                count+=dp[i][j];
            }
        }
        return count;
    }
}
