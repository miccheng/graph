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
        int start = 0;
        int end = 0;
        int head=0;
        int min = Integer.MAX_VALUE;
        int count = map.size();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }

            while(count==0){
                char c1 = s.charAt(start);
                if(map.containsKey(c1)){
                    map.put(c1,map.get(c1)+1);
                    if(map.get(c)>0) count++;
                }
            }

            //min=Math.min(min,end-start);
            if(end-start < min){
                min = end - start;
                head = start;
            }
            start++;
        }

        if(min == Integer.MAX_VALUE) return "";
        return s.substring(head, head+min);
    }
}
