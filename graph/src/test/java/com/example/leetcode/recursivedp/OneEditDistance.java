package com.example.leetcode.recursivedp;

public class OneEditDistance {
    public static void main(String[] args) {
        minDistance("sea","eat");
    }
    //start from recursive: Solution 1
    public boolean isOneEditDistance(String s, String t) {
        if(s==null|| t==null) return false;
        if(s.length()==0 && t.length()==0) return true;
        if(s.length()==0|| t.length()==0) return false;

        if(s.length()>=t.length())
            return recurisve(t,0,s,0)==1;
        else
            return recurisve(s,0,t,0)==1;

    }

    public int recurisve(String s,int i, String t, int j) {
        int len1=s.length();
        int len2=t.length();

        if(i>=len1) return len2-j;
        if(j>=len2) return len1-i;

        if(s.charAt(i)==t.charAt(j)){
            return recurisve(s,i+1,t,j+1);
        }else{
            return Math.min(Math.min(recurisve(s,i,t,j+1),recurisve(s,i+1,t,j)), recurisve(s,i+1,t,j+1)) +1;
        }
    }

    //Solution 2:
    public boolean isOneEditDistanceDp(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() == 0 && t.length() == 0) return false;
        //***when 1 is empty, can't simply return true or false
        if (s.length() == 0) return t.length() == 1;
        if (t.length() == 0) return s.length() == 1;

        int len1 = s.length();
        int len2 = t.length();
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
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }


        return dp[len1][len2] == 1;
    }

    //leetcode 583 :Delete Operation for Two Strings
    public static int minDistance(String word1, String word2) {
        if(word1==null|| word2==null) return 0;
        int len1=word1.length();
        int len2=word2.length();

        if(len1==0) return len2;
        if(len2==0) return len1;

        int [][]dp=new int [len1+1][len2+1];
        dp[0][0]=0;

        for(int i=1;i<=len1;i++){
            dp[i][0]=i;
        }

        for(int j=1;j<=len2;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+1;
            }
        }

        return dp[len1][len2];
    }

}
