package com.example.leetcode.strchar;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//count[charAt(i)-'a'] problem: refer to anagram, 1st non repeating character
public class A2i {

    //Hand overflow
    public static int myAtoi2(String s) {
        if(s==null) return 0;
        long count=0;
        int i=0;
        int len=s.length();
        int sign=1;

        while(i<len&&s.charAt(i) == ' '){
            i++;
        }
        if(i==len) return 0;

        if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(i)=='+'){
            sign=1;
            i++;
        }


        while(i<len&&Character.isDigit(s.charAt(i))){
            count = count * 10 + s.charAt(i) - '0';
            if (count > Integer.MAX_VALUE) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            i++;
        }

        return (int)count*sign;
    }


    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        //**1.trim and check length
        s = s.trim();
        int len = s.length();
        if (len == 0) return 0;

        int sign = 1;
        long num = 0;//must declare as long

        //***2. get first char as sign if it is explicit
        int i = 0;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        //3.+-12 will return 0; break when it is not in the range
        for (; i < len; i++) {
            char cur = s.charAt(i);
            if (!(cur - '0' >= 0 && cur - '0' <= 9)) {
                return (int) num * sign;
            }
            num = num * 10 + cur - '0';
            if (sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        }
        return (int) num * sign;
    }

}