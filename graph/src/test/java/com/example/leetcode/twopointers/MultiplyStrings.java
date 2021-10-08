package com.example.leetcode.twopointers;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();

        int product[]=new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int p1=i+j;
                int p2=i+j+1;

                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+product[p2];
                product[p1]+=mul/10;
                product[p2]=mul%10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int n: product){
            if(sb.length()==0&&n==0) continue;
            sb.append(n);
        }

        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
