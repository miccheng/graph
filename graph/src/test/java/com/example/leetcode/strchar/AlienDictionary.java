package com.example.leetcode.strchar;


//count[charAt(i)-'a'] problem: refer to anagram, 1st non repeating character, atoi
public class AlienDictionary {
    public static void main(String args[]) {
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        boolean flag = isAlienSorted(words, order);
        System.out.println(flag);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) return true;

        int dict[] = new int[26];
        int len = order.length();
        for (int i = 0; i < len; i++) {
            char c = order.charAt(i);
            dict[c - 'a'] = i;
        }

        int len2 = words.length;
        for (int i = 0; i < len2 - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            if (!compareWord(cur, next, dict)) return false;
        }

        return true;
    }

    private static boolean compareWord(String cur, String next, int dict[]) {
        int minLen = Math.min(cur.length(), next.length());
        for (int j = 0; j < minLen; j++) {
            if (cur.charAt(j) != next.charAt(j)) return dict[cur.charAt(j) - 'a'] < dict[next.charAt(j) - 'a'];
        }
        if (cur.length() > next.length()) return false;
        return true;
    }

}