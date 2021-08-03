package com.example.leetcode.recursivedp;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        shortestCommonSupersequence(str1,str2);
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        if(str1==null||str1.length()==0) return str2;
        if(str2==null||str2.length()==0) return str1;

        int len1=str1.length();
        int len2=str2.length();

        String [][] dp=new String[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]==null?""+str1.charAt(i-1):dp[i-1][j-1]+str1.charAt(i-1);
                }else{
                    if(dp[i-1][j]==null){
                        dp[i][j]=dp[i][j-1];
                        continue;
                    }
                    if(dp[i][j-1]==null){
                        dp[i][j]=dp[i-1][j];
                        continue;
                    }
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()? dp[i-1][j]:dp[i][j-1];
                }
            }
        }

        String lcs=dp[len1][len2];

        //***recover string by using 3 pointers
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lcs.length(); i++) {
            while(p1 < str1.length() && str1.charAt(p1) != lcs.charAt(i)) {
                sb.append(str1.charAt(p1++));
            }
            while(p2 < str2.length() && str2.charAt(p2) != lcs.charAt(i)) {
                sb.append(str2.charAt(p2++));
            }
            sb.append(lcs.charAt(i));
            p1++;
            p2++;
        }
        sb.append(str1.substring(p1)).append(str2.substring(p2));
        return sb.toString();
    }
}
