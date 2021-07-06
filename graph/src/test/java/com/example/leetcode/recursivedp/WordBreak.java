package com.example.leetcode.recursivedp;

import org.assertj.core.util.Lists;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s="applepenapple";
        List<String> list = Lists.newArrayList("apple","pen");
        wordBreak(s,list);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (String str : wordDict) {
                if (dp[i] == true && s.startsWith(str, i-1)) {
                    dp[i + str.length()] = true;
                }
            }
        }
        return dp[len];
    }
}
