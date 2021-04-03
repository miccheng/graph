package com.example.leetcode.stringrecursive;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WrongMemo {
    public static void main(String args[]) {
        String str = "aab";
        Map<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> subsets = getAllSubsets(str,map);
        System.out.println();
    }

    private static List<List<String>> getAllSubsets(String target,Map<String, List<List<String>>> map) {
        if(map.containsKey(target)) return map.get(target);

        List<List<String>> results = Lists.newArrayList();
        //base case
        if (target.isEmpty()) {
            results.add(new ArrayList<String>());
            return results;
        }

        int end = target.length();
        List<String> choices = getChoices(target, end);
        for (String choice : choices) {
            //check choice is palindrome or not
            if (checkIsPalindrome(choice)) {
                //check exist in cach
                String suffix = target.substring(choice.length());
                List<List<String>> allSubsets = getAllSubsets(suffix,map);
                allSubsets.stream().forEach(e -> e.add(choice));
                results.addAll(allSubsets);
            }
        }
        map.put(target,results);
        return results;
    }

    private static boolean checkIsPalindrome(String choice) {
        int left = 0;
        int right = choice.length() - 1;
        while (left < right) {
            if (choice.charAt(left) != choice.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static List<String> getChoices(String str, int end) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= end; i++) {
            list.add(str.substring(0, i));
        }
        return list;
    }


}
