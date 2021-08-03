package com.example.leetcode.arraystr;

public class AddStrings {
    public static void main(String[] args) {
        String num1="1";
        String num2="9";
        addStrings(num1,num2);
    }

    public static String addStrings(String num1, String num2) {
        if(num1==null|| num1.length()==0) return num2;
        if(num2==null|| num2.length()==0) return num1;

        int len1=num1.length();
        int len2=num2.length();


        int i=len1-1;
        int j=len2-1;
        long carryover=0;
        StringBuilder builder=new StringBuilder();
        while(i>=0||j>=0){
            long n1=i>=0?num1.charAt(i)-'0':0l;
            long n2=i>=0?num2.charAt(j)-'0':0l;
            long sum=n1+n2+carryover;
            long number=sum%10;
            builder.append(number);
            carryover=sum/10;

            i--;
            j--;
        }

        if(carryover!=0){
            builder.append(carryover);
        }

        return builder.reverse().toString();
    }
}
