package com.example.leetcode.slidingwindow;

import org.assertj.core.util.Lists;

import java.util.*;
//*****Sliding window with an expanding size + frequency table
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String target = "ebacbabacd";
        String pattern = "abc";
        int [] expected={0,6};
        findAnagrams(target, pattern);
    }

    //standard approach with hashmap
    public static List<Integer> findAnagramsTemplate(String s, String t) {
        List<Integer> result = new ArrayList<>();
        if(t.length()> s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            end++;//***move end forward

            if(count>0) continue;//***important

            //restore the map
            //***********keep looping the until count>0 to shave the unnecessary in front
            while (count == 0) {
                char temp = s.charAt(start);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) count++;
                }
                //anagram is supposed to be at same length. no extra alphabet mixing
                if (end - start == t.length()) {
                    result.add(start);
                }
                start++;//***move start forward
            }
        }

        return result;
    }

    private static List<Integer> findAllAnagramsArray(String target, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (target == null || pattern == null || "".equals(target) || "".equals(pattern)) return Lists.newArrayList();

        int count[] = new int[26];
        for (char c : pattern.toCharArray()) {
            count[c - 'a']++;
        }

        int start = 0;
        int end = 0;
        int counter = pattern.length();
        int len = pattern.length();
        while (end < target.length()) {
            char c = target.charAt(end);
            if (count[c - 'a'] >= 1) {
                count[c - 'a']--;
                counter--;
            }
            end++;

            while (counter == 0) {
                char c1 = target.charAt(start);
                if (count[c1 - 'a'] >= 0) {
                    count[c1 - 'a']++;
                    counter++;
                }

                if (end - start == pattern.length()) result.add(start);
                start++;
            }

        }


        return result;
    }

    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> result=new ArrayList<>();
        if(s==null||s==null||s.length()==0|| t.length()==0) return result;

        Map<Character, Integer> map=new HashMap<>();
        for(char c :t.toCharArray()){
            map.put(c, map.getOrDefault(c+"",0)+1);
        }

        int i=0;
        int j=0;
        int count=map.size();
        int len=s.length();

        while(j<len) {
            Character current = s.charAt(j);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) count--;
            }
            j++;
            if (count > 0) continue;

            while (count == 0) {
                Character pre = s.charAt(i);
                if (map.containsKey(pre)) {
                    map.put(pre, map.get(pre) + 1);
                    if (map.get(pre) > 0) count++;
                }

                if (j - i == t.length()) result.add(i);
                i++;
            }


        }


        return result;
    }
}
