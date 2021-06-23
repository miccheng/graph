package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        isPalindrome("ab");
        partitionY("aab");
    }
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



    public static List<List<String>> partitionY(String s) {
        List<List<String>> result=new ArrayList<>();
        recursive(s,new ArrayList<>(),result);
        return result;
    }

    public static void recursive(String s,List<String> path, List<List<String>> result){
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




    public static boolean isPalindrome(String s){
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
}
