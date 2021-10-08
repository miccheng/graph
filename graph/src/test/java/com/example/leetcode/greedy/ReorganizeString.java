package com.example.leetcode.greedy;
import java.util.*;
//https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
    public static String reorganizeString(String S) {
        int[] chars = new int[26];
        for (char c : S.toCharArray()) {
            chars[c - 'a']++;
        }
        //get the most frequent number
        int max = 0;
        int letter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > max) {
                max=chars[i];
                letter = i;
            }
        }
        //too frequent
        if (max > (S.length() + 1) / 2) return "";

        char[] organized = new char[S.length()];
        int index = 0;
        while (max > 0) {
            organized[index] = (char) (letter + 'a');
            index+= 2;
            //****must decrease from frequency table
            chars[letter]--;
            max--;
        }

        //distribute the rest of the items
        for (int i = 0; i < chars.length; i++) {
            while (chars[i] != 0) {
                if (index >= S.length()) index = 1;//restart
                organized[index] = (char) (i + 'a');
                //****decrease from original frequency table
                chars[i]--;
                index+= 2;
            }
        }

        return String.valueOf(organized);
    }

    //solution 2:
    public String reorganizeString2(String s) {
        if(s==null||s.length()==0) return s;
        int len=s.length();

        PriorityQueue<Map.Entry<Character, Integer>> heap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        Map<Character, Integer> map=new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> e:map.entrySet()){
            heap.add(e);
        }

        StringBuilder sb=new StringBuilder();
        while(!heap.isEmpty()){
            int n=2;
            List<Map.Entry<Character, Integer>> tmp=new ArrayList<>();
            while(n>0&&!heap.isEmpty()){
                Map.Entry<Character, Integer> e=heap.poll();
                sb.append(e.getKey());
                int fre=e.getValue();
                if(fre>1){
                    e.setValue(fre-1);
                    tmp.add(e);
                }
                n--;
            }
            if(n>0&&tmp.size()!=0) return "";
            heap.addAll(tmp);
        }

        return sb.toString();
    }
}
