package com.example.leetcode.slidingwindow;

import org.assertj.core.util.Lists;

import java.util.*;
//*****Sliding window with an expanding size + frequency table
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String target = "cbaebabacd";
        String pattern = "abc";
        int [] expected={0,6};
        findAnagramsTemplate(target, pattern);
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

            if(count>0) continue;

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

    //use two reference
    private static List<String> findAllAnagrams(String target, String pattern) {
        List<Integer> indice = new ArrayList<>();
        if (target == null || pattern == null || "".equals(target) || "".equals(pattern)) return Lists.newArrayList();

        char[] reference = new char[26];
        char[] scan = new char[26];

        for (char c : pattern.toCharArray()) {
            reference[c - 'a']++;
        }

        int count = 0;
        int start = 0;
        int end = 0;
        //slide window for the target
        for (int i = start; i < target.length(); i++) {
            scan[target.charAt(i) - 'a']++;
            count++;

            if (count == pattern.length()) {
                boolean flag = Arrays.equals(reference, scan);
                if (flag) {
                    indice.add(start);
                }
                //remove one char from scan and reset start;
                scan[target.charAt(start) - 'a']--;
                count--;
                start++;
                end++;

            }
        }
        //toString
        System.out.println();
        return null;
    }

}
