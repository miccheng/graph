package com.example.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//*****Variation of sliding window
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String []words ={"foo","bar"};
        findSubstringS(s,words);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = words.length;
        int m = words[0].length();
        int count = n;
        for (int i = 0; i <= s.length() - n * m; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int j = i;
            while (count > 0) {
                String str = s.substring(i, i + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, map.get(str) - 1);
                count--;
                j += m;
            }

            if (count == 0) result.add(i);
        }
        return result;
    }

    //to be fixed
    public static List<Integer> findSubstringS(String s, String[] words) {
        List<Integer> result=new ArrayList<>();
        if (s==null|| words==null|| s.length()==0||words.length==0) return result;

        Map<String, Integer> map=new HashMap<>();
        for(String str: words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        int i=0;
        int j=0;
        int count=map.size();
        int len=words.length;
        int l=words[0].length();

        while(j<len) {
            for (int k = j; k <= j + l; k++) {
                String cur = s.substring(j, k);
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) count--;
                }
            }
            j++;
            if (count >0) continue;

            while (count <= 0) {
                if (j - i == len * l) {
                    result.add(i);
                }
                for (int q = i; q <= i + l; q++) {
                    String pre = s.substring(i, q);
                    if (map.containsKey(pre)) {
                        map.put(pre, map.get(pre) + 1);
                        if (map.get(pre) == 0) count++;
                    }
                }
                i++;
            }
        }

        return result;
    }
}
