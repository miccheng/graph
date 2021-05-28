package com.example.leetcode.greedy;

//https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
    public static String reorganizeString(String S) {
        int[] chars = new int[26];
        for (char c : S.toCharArray()) {
            chars[c - 'a']++;
        }
        //get the most frequent number
        int max = 0;
        int letter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > max) {
                max=chars[i];
                letter = i;
            }
        }
        //too frequent
        if (max > (S.length() + 1) / 2) return "";

        char[] organized = new char[S.length()];
        int index = 0;
        while (max > 0) {
            organized[index] = (char) (letter + 'a');
            index+= 2;
            //****must decrease from frequency table
            chars[letter]--;
            max--;
        }

        //distribute the rest of the items
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] != 0) {
                if (index >= S.length()) index = 1;//restart
                organized[index] = (char) (i + 'a');
                //****decrease from original frequency table
                chars[i]--;
                index+= 2;
            }
        }

        return String.valueOf(organized);
    }

}
