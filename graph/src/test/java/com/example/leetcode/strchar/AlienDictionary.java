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
        int[] alphabet =new int [26];
        //super important !!!
        for (int i = 0; i < order.length(); i++) {
            alphabet[order.charAt(i)-'a']=i;
        }

        for (int i = 0; i < words.length; i++) {
            int j=i+1;

            int len = Math.min(words[i].length(), words[j].length());
            for (int k = 0; k < len; k++) {
                int ci = words[i].charAt(k) - 'a';
                int cj = words[j].charAt(j) - 'a';
                if (alphabet[ci] > alphabet[cj]) return false;
                if (k == len - 1 && words[i].length() > words[j].length()) return false;
            }

        }

        return true;
    }
}