package com.example.leetcode.recursivestring;

import org.assertj.core.util.Lists;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String target="leetcode";
        List<String> words=Lists.newArrayList("leet","code");
        recursive(target,words, new HashMap<String, Boolean>());
    }

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

    static boolean recursive(String s, List<String> wordDict, Map<String,Boolean> map){
        if(s==null) return false;
        if("".equals(s)) return true;

        if(map.containsKey(s)) return map.get(s);
        for(String str : wordDict){
            if(s.indexOf(str)==0){
                if(recursive(s.substring(str.length()), wordDict,map)==true) {
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
}
