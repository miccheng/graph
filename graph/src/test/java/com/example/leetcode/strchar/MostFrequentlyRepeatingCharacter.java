package com.example.leetcode.strchar;
//O(1) space
public class MostFrequentlyRepeatingCharacter {
    public char maxOccurringChar(String str) {
        int max = 0;
        int count[] = new int[256];
        char result = ' ';

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] > max) {
                result = str.charAt(i);
                max = count[str.charAt(i) - 'a'];
            }
        }
        return result;
    }
}
