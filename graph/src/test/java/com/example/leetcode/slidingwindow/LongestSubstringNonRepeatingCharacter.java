package com.example.leetcode.slidingwindow;

import java.util.*;

public class LongestSubstringNonRepeatingCharacter {
    String str="aaabebcdd";

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int len = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            len = Math.max(len, end - start + 1);
            set.add(c);
            end++;
        }
        return len;
    }

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
