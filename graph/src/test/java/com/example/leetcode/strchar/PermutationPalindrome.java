package com.example.leetcode.strchar;

public class PermutationPalindrome {
    public boolean isPermutationPalindrome(String s) {
        //build char frequency table
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        //check odds(1,3), even(0,2)
        int count = 0;
        for (int i = 0; i < 128; i++) {
            count += letters[i] % 2;
        }
        return count <= 1 ;
    }
}
