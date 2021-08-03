package com.example.leetcode.arraystr;

public class CountBinarySubstrings {
    //group
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int group[] = new int[len];

        group[0] = 1;
        int t = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                t++;
                group[t]++;
            } else {
                group[t]++;
            }
        }

        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            count += Math.min(group[i], group[i + 1]);
        }

        return count;
    }
}
