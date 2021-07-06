package com.example.leetcode.recursive.backtracking;

import java.util.*;

public class PermutationOfString {
    public static void main(String[] args) {
        int arr[]={6,4,7,8,2,10,2,7,9,7};
        minCostToMoveChipsC(arr);

        String input = "abc";
        List<String> result = new ArrayList<>();
        permutateS(input, "");

        permutateShell(input, result);
        System.out.println(result);
    }

    //solution 2:
    public static void permutateS(String input, String prefix) {

        if (input.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < input.length(); i++) {
                String remain = input.substring(0, i) + input.substring(i + 1);
                permutateS(remain, prefix + input.charAt(i));
            }
        }
    }

    //Solution 1: backtracking
    //mark take ele. here leverage set. array can be used as well
    private static void permutateShell(String input, List<String> result) {
        if (input.length() <= 1) return;
        permutate(input, new HashSet<Character>(), "", result);
    }

    public static void permutate(String input, Set<Character> set, String prefix, List<String> result) {
        if (prefix.length() == input.length()) {
            result.add(prefix);
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                prefix = prefix + c;
                permutate(input, set, prefix, result);
                prefix = prefix.substring(0, prefix.length() - 1);
                set.remove(c);
            }
        }
    }


    static int minCostToMoveChipsC(int [] chips) {
        int odd = 0, even = 0;
        for(int i = 0; i < chips.length; i++)
           if (chips[i] % 2 == 1) {
               odd++;
           } else {
               even++;
           }
        return Math.min(odd, even);
    }
}
