package com.example.leetcode.twopointers;

import com.sun.org.apache.xpath.internal.objects.XString;

public class ReverseOnlyLettersInString {
    public static void main(String[] args) {
        String input="a-bC-dEf-ghIj";
        //output: "j-Ih-gfE-dCba"
        String s = reverseOnlyLetters(input);
        System.out.println(s);
    }

    public static String reverseOnlyLetters(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            while (!Character.isLetter(str.charAt(i))) i++;
            while (!Character.isLetter(str.charAt(j))) j--;
            //swap
            char c1 = str.charAt(i);
            char c2 = str.charAt(j);

            chars[i]=c2;
            chars[j]=c1;

            i++;
            j--;
        }
        return new String(chars);
    }
}