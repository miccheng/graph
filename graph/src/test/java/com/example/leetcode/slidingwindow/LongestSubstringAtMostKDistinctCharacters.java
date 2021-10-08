package com.example.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||s.length()==0||k==0) return 0;

        int len=s.length();

        int i=0;
        int j=0;
        int max=0;
        Map<Character, Integer> map=new HashMap<>();
        while(j<len){
            char c=s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            while(i<j&&map.size()>k){
                char left=s.charAt(i);
                map.put(left, map.getOrDefault(left,0)-1);
                if(map.get(left)==0) map.remove(left);
                i++;
            }
            max=Math.max(j-i+1,max);
            j++;
        }

        return max;
    }
}
