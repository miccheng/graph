package com.example.leetcode.assorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        String s = "ifailuhkqq";
        anagramPair(s);
    }

    public static int anagramPair(String s) {
        int totalLen = s.length();
        int pair = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int len = 1; len <= totalLen; len++) {//fix length
            for (int i = 0; i <= totalLen - len; i++) {//same length, different map
                char[] charArray = s.substring(i, i + len).toCharArray();//substring directly, isntead of collecting char 1by1
                Arrays.sort(charArray);
                String subStr = new String(charArray);
                if (map.containsKey(subStr))
                    map.put(subStr, map.get(subStr) + 1);
                else
                    map.put(subStr, 1);
            }
        }

        for (String key : map.keySet()) {//combination C(2,3)=n!/r!*(n-r)!
            int fre = map.get(key);
            pair += (fre * (fre - 1)) / 2;
        }
        return pair;
    }
}