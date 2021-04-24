package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        getPalindrome(0,s,new ArrayList<String>(),result);
        return result;
    }

    private void getPalindrome(int index, String s,List<String> path, List<List<String>> result) {
        if (index == s.length()) result.add(new ArrayList<>(path));

        path.add(s.substring(0, index));
        for (int i = index; i < s.length(); i++) {//a,aa,aab
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                getPalindrome(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s,int index, int i) {
        while (index < i) {
            if (s.charAt(index) != s.charAt(i)) return false;
        }
        return true;
    }


}
