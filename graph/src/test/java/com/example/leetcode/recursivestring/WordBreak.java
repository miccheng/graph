package com.example.leetcode.recursivestring;

import org.assertj.core.util.Lists;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String target="leetcode";
        List<String> words=Lists.newArrayList("leet","code");
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


    //memorize which substring can be constructed . here [beg, len-1]
    private boolean recursive(String s, List<String> wordDict, int beg, Map<Integer, Boolean> map ){
        if(beg==s.length()) return true;
        if(beg>s.length())  return false;
        if(map.containsKey(beg)) return map.get(beg);

        for(int i=0;i<wordDict.size();i++){
            String cur=wordDict.get(i);
            if(s.startsWith(cur, beg)){
                if(recursive(s,wordDict, beg+cur.length(), map)) {
                    map.put(beg, true);
                    return true;
                }
            }
        }
        map.put(beg, false);
        return false;
    }
}
