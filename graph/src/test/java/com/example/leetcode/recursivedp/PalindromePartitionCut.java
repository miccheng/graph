package com.example.leetcode.recursivedp;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PalindromePartitionCut {

    public static void main(String[] args) {
        String s = "aab";
        minCut(s);
    }

    public static int minCut(String s) {
        if(s==null|| s.length()==0) return 0;
        int cut=recursive(0,s, new HashMap<Integer, Integer>());
        return cut;
    }

    public static int recursive(int start, String s, Map<Integer, Integer> map) {
        int len=s.length();
        if(start>=len) return -1;

        if (map.containsKey(start)) {
            return map.get(start);
        }

        int minCut=Integer.MAX_VALUE;
        for(int i=start+1;i<=len;i++){
            String cur=s.substring(start,i);
            int cuts=Integer.MAX_VALUE;
            if(isPalindrome(cur)) {
                cuts = recursive(i, s,map) + 1;
            }
            minCut=Math.min(minCut,cuts);
        }
        map.put(start,minCut);
        return minCut;
    }


    private static boolean isPalindrome(String s){
        if(s==null) return false;
        int len=s.length();
        if(len==0) return true;

        int i=0; int j=len-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
