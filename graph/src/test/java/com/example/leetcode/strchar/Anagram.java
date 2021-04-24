package com.example.leetcode.strchar;

import org.assertj.core.util.Lists;

import java.util.*;

//sliding window
//count[charAt(i)-'a'] problem: refer to alien dictionary, 1st non repeating character, atoi

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
        Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
        The order of output does not matter.
*/
public class Anagram {
    public static void main(String args[]) {
        char[] no1 = new char[26];
        char[] no2 = new char[26];
        for (char c : "eat".toCharArray()) {
            no1[c - 'a']++;
        }
        for (char c : "tea".toCharArray()) {
            no2[c - 'a']++;
        }

        System.out.println(no1 == no2);
        System.out.println(no1.equals(no2));//why
        System.out.println(Arrays.equals(no1, no2));
        System.out.println(no1);
        System.out.println(String.valueOf(no1).equals(String.valueOf(no2)));

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        groupAnagram(strs);

    }




        //use 2 maps to compare
        //Map.equals();
        //first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())));


    private static List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                List<String> list = Lists.newArrayList();
                map.put(keyStr, list);
            }
            map.get(keyStr).add(str);
        }
        return Lists.newArrayList(map.values());
    }
}
