package com.example.leetcode.arraystr;

public class MultipleStrings {
    public static void main(String[] args) {
        String num1="2";
        String num2="3";
        multiply(num1,num2);
    }
    public static String multiply(String num1, String num2) {
        if(Integer.valueOf(num1)==0||Integer.valueOf(num2)==0) return "0";
        if(Integer.valueOf(num1)==1) return num2;
        if(Integer.valueOf(num2)==1) return num1;


        int result=0;

        int len1=num1.length();
        int len2=num2.length();
        String shorter=len1<len2?num1:num2;
        int longer=len1<len2?Integer.valueOf(num2):Integer.valueOf(num1);

        int shortLen=len1<len2?len1:len2;

        for(int j=shortLen-1;j>=0;j--){
            int cur=shorter.charAt(j)-'0';
            result+=(int)(longer *cur*(Math.pow(10,shortLen-j-1)));
        }


        return String.valueOf(result);
    }
}
