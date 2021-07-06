package com.example.leetcode.recursivestring;

import org.assertj.core.util.Lists;

import java.util.*;

//All sub set problem(power set)
public class PalindromePartition {
    //version 1:
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        recursive(s,new ArrayList<String>(),result);
        return result;
    }

    public void recursive(String s,List<String> path, List<List<String>> result){
        if("".equals(s)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=1;i<=s.length();i++){
            String prefix=s.substring(0,i);
            if(isPalindrome(prefix)){
                path.add(prefix);
                recursive(s.substring(i), path, result);
                path.remove(path.size()-1);
            }
        }
    }


    public boolean isPalindrome(String s){
        int i=0; int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

//version 2:
    private static List<List<String>> getAllSubsets(String target) {
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
                //check exist in cache
                String suffix = target.substring(choice.length());
                List<List<String>> allSubsets = getAllSubsets(suffix);
                allSubsets.stream().forEach(e -> e.add(choice));
                results.addAll(allSubsets);
            }
        }

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


//    private void expandPalindrome(int start, int end, String str) {
//        int len=0;
//        while (start >= 0 && end <= str.length()) {
//            if(str.charAt(start)==str.charAt(end)){
//                len=Math.max(len,end-start+1);
//                start--;
//                end++;
//            }
//        }
//        return;///len
//    }
//
//    private void buildPalindromDp(int start, int end, String str) {
//        int len = str.length();
//        boolean[][] dp = new boolean[len][len];
//        for (int i = len - 1; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == true)) {
//                    dp[i][j] = true;
//                    //update index and max length
//                }
//
//            }
//        }
//    }
}
