package com.example.leetcode.recursivestring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 0; i <= n; i++) {
            if (dp[i] == true) {
                String remainder = s.substring(i, s.length());
                for (String current : set) {
                    int index = remainder.indexOf(current);
                    if (index == 0) {
                        dp[i + current.length()] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
