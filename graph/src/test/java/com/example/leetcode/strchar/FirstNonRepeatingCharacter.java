package com.example.leetcode.strchar;

public class FirstNonRepeatingCharacter {
    public static void main(String args[]){
        String input="loveleetcode";
        int index = findCharacter(input);
        System.out.println(index);
    }

    private static int findCharacter(String input) {
        int length = input.length();
        int count[]=new int[26];
        for (int i = 0; i < length -1; i++) {
           count [input.charAt(i)-'a']++;
        }

        for (int i = 0; i < length-1; i++) {
            if (count[input.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
