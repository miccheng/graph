package com.example.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            set.add(c);
            end++;

            while (set.size() > 2) {
                set.remove(s.charAt(start));
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
