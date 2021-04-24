package com.example.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s="pwwkew";
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            while (set.contains(c)) {
                set.remove(s.charAt(j));
                i++;
            }
            set.add(c);
            max = Math.max(max, j - i + 1);
            j++;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                max = Math.max(set.size(),max);
            } else {
                set.remove(c);
                i++;
            }
        }

        return max;
    }
}
