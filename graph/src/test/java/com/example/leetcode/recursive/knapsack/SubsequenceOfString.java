package com.example.leetcode.recursive.knapsack;

public class SubsequenceOfString {
    public static void main(String[] args) {
        String s = subsequences("abc");
        System.out.println();
    }


    public static String subsequences(String word) {
        return subsequencesAfter("", word);
    }

    private static String subsequencesAfter(String partialSubsequence, String word) {
        if (word.isEmpty()) {
            // base case
            return partialSubsequence;
        } else {
            // recursive step
            return subsequencesAfter(partialSubsequence, word.substring(1))
                    + ","
                    + subsequencesAfter(partialSubsequence + word.charAt(0), word.substring(1));
        }
    }
}
