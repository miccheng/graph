package com.example.leetcode.recursive.knapsack;

public class InterleavingString {

    //either the character is having the choice of coming from s1 or s2
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s1.length()==0) return s2.equals(s3);
        if(s2==null || s2.length()==0) return s1.equals(s3);

        if(s1.length()+s2.length()!=s3.length()) return false;

        return recursive(s1,s2,s3);
    }

    //naive approach: solution 1
    public boolean recursive(String s1,String s2,String s3){
        if(s1.length()==0) return s2.equals(s3);
        if(s2.length()==0) return s1.equals(s3);

        boolean flag1=false;
        boolean flag2=false;
        if(s1.charAt(0)==s3.charAt(0)) flag1= recursive(s1.substring(1),s2, s3.substring(1));
        if(s2.charAt(0)==s3.charAt(0)) flag2= recursive(s1, s2.substring(1),s3.substring(1));

        return flag1||flag2;
    }

    //modification
    public boolean recursive(String s1,int i, String s2, int j, String s3, int k) {
        if (i >= s1.length()) return s2.substring(j).equals(s3.substring(k));
        if (j >= s2.length()) return s1.substring(i).equals(s3.substring(k));

        boolean flag1 = false;
        boolean flag2 = false;
        if (s1.charAt(i) == s3.charAt(k)) flag1 = recursive(s1, i + 1, s2, j, s3, k + 1);
        if (s2.charAt(j) == s3.charAt(k)) flag2 = recursive(s1, i, s2, j + 1, s3, k + 1);

        return flag1 || flag2;
    }

    //Improvement: add memo to recursion
    public boolean recursiveMemo(String s1,int i, String s2, int j, String s3, int k, boolean dp[][]) {
        if (i >= s1.length()) return s2.substring(j).equals(s3.substring(k));
        if (j >= s2.length()) return s1.substring(i).equals(s3.substring(k));

        boolean flag1 = false;
        boolean flag2 = false;
//        if(dp[i][j]) ! undefined, then return here
        if (s1.charAt(i) == s3.charAt(k)) flag1 = recursive(s1, i + 1, s2, j, s3, k + 1);
        if (s2.charAt(j) == s3.charAt(k)) flag2 = recursive(s1, i, s2, j + 1, s3, k + 1);

        dp[i][j] = flag1 || flag2;//cache the result
        return flag1 || flag2;
    }

    //Think iterative. Transform to dp
    //Solution 2: Bottom up dp
    public static boolean isInterleaveDp(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) dp[i][j] = dp[i - 1][j];
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
