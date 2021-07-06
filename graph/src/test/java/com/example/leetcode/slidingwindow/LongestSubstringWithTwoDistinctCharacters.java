package com.example.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithTwoDistinctCharacters {
    public static void main(String[] args) {
        //"eceba" k=2  "ece"
        lengthOfLongestSubstringKDistinct("eceba",2 );
    }


    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||s.length()==0) return 0;

        int i=0;
        int j=0;
        Map<Character, Integer> map=new HashMap<>();
        int count=map.size();
        int len=s.length();
        int max=0;

        while(j<len) {
            char cur = s.charAt(j);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            count = map.size();

            while (count > k) {
                char pre = s.charAt(i);
                map.put(pre, map.get(pre) - 1);
                if (map.get(pre) == 0) map.remove(pre, 0);
                count = map.size();
                i++;
            }
            if (j - i + 1 > max) {
                max = j - i + 1;
            }
            j++;
        }

        return max;
    }


}
