package com.example.leetcode.strchar;


//count[charAt(i)-'a'] problem: refer to anagram, 1st non repeating character
public class A2i {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        char c='1';
        int i = c - '0';
        System.out.println(i);
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public Integer atoi(String str) {
        int result = 0;
        int sign = 1;
        int i = 0;

        //negative
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        }

        for (; i < str.length(); i++) {
            if (!isDigit(str.charAt(i))) {
                return -1;
            }
            if (!(result > Integer.MAX_VALUE)) result = result * 10 + str.charAt(i) - '0';
        }

        //apply sign
        result = result * sign;
        return result;

    }


}
