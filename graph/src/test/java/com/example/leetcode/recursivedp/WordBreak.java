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
        Map <String, Integer> map=new HashMap<>();
        for(String c:wordDict){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        // int len= s.length();
        // boolean[] dp=new boolean[len+1];
        //  dp[0]=true;


        for(Map.Entry<String, Integer> e:map.entrySet()){
            String c=e.getKey();
            int i = s.indexOf(c);
            if(i!=-1){
                map.put(c,map.get(c)-1);
                s=s.substring(0,i);
            }
        }

        for(Map.Entry<String, Integer> e:map.entrySet()){
            if(e.getValue()>0) return false;
        }
        return true;
    }
}
