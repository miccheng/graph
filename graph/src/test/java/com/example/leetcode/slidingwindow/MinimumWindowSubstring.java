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
        String result = "";
        int resultLen = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        int len = s.length();

        while (j < len) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) count--;
            }
            j++;
            if (count > 0) continue;

            while (i < len && count == 0) {
                char pre = s.charAt(i);
                if (map.containsKey(pre)) {
                    map.put(pre, map.get(pre) + 1);
                    if (map.get(pre) > 0) count++;
                }
                i++;
            }
            if (j - i - 1 < resultLen) {
                resultLen = j - i - 1;
                result = s.substring(i - 1, j);
            }
        }

        return result;
    }
}
