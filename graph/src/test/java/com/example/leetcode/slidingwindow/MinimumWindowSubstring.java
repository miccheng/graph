package com.example.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String output = "BANC";
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int head = 0;
        int min = Integer.MAX_VALUE;
        int count = map.size();

        while (j < s.length()) {
            char endChar = s.charAt(j);
            j++;
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) count--;
            }
            if (count > 0) continue;//advance j

            //*** cal maxLen, invalid map
            while (count == 0) {
                //min=Math.min(min,j-i);
                if (j - i < min) {
                    min = j - i;
                    head = i;
                }

                char startChar = s.charAt(i);
                i++;
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) count++;
                }
            }
        }

        if (min == Integer.MAX_VALUE) return "";
        return s.substring(head, head + min);
    }

    
}
