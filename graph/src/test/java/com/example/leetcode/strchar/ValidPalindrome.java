package com.example.leetcode.strchar;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s="0P";
        isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        if(s==null|| s.length()==0) return true;
        s=s.replace("\\s","");
        int len=s.length();

        int i=0;
        int j=len-1;
        while(i<=j){
            while(i<len&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j>=0&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i<len&&j>=0&&Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
