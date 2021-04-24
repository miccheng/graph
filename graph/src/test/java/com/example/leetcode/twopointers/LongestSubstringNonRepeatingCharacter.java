package com.example.leetcode.twopointers;

import java.util.HashSet;

public class LongestSubstringNonRepeatingCharacter {
    String str="aaabebcdd";
    public int findUniformString(String str) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int len = 0;

        while (end < str.length()) {
            char c = str.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                len = Math.max(len, set.size());
                end++;
            } else {
                set.remove(c);
                start++;
            }

        }
        return len;
    }
}
