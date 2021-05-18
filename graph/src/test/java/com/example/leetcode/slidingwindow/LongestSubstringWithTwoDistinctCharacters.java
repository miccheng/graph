package com.example.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithTwoDistinctCharacters {
    //"eceba" k=2  "ece"
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

    public int lengthOfLongestSubstringKDistinct(String s) {
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            set.add(c);
            while (set.size() > 2) {
                set.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

}
