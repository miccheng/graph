package com.example.leetcode.recursivedp;

import org.assertj.core.util.Lists;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
//        String s="applepenapple";
//        List<String> list = Lists.newArrayList("apple","pen");
//        wordBreak(s,list);

        String target="aaaaaaa";
        List<String> banks = Lists.newArrayList("aaaa","aaa");
        wordBreak(target,banks);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null | s.length() == 0) return true;
        if (wordDict == null | wordDict.size() == 0) return false;
        int len = s.length();
        boolean dp[] = new boolean[len+1];
        dp[0]=true;
        Math.random();

        return dp[len];
    }
}
