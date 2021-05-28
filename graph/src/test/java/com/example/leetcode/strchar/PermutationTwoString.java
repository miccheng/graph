package com.example.leetcode.strchar;

public class PermutationTwoString {
    //even(0) and odd(1)
    public boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int count[] = new int[128];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (char c : s2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }
}
