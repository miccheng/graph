package com.example.leetcode.arraystr;

import java.util.*;

public class MaximumSwap {
    public int maximumSwap(int num) {
        if(num==0) return 0;
        TreeMap<Integer,Set<Integer>> map=new TreeMap<>(Collections.reverseOrder());//num->index

        char [] chars=(num+"").toCharArray();
        for(int i=0;i<chars.length;i++){
            int n=Integer.valueOf(chars[i]);
            map.putIfAbsent(n,new HashSet<>());
            map.get(n).add(i);
        }

        for(int i=0;i<chars.length;i++){
            int n=Integer.valueOf(chars[i]);
            if(n<map.firstKey()){
                int j=-1;
                for(int index:map.get(map.firstKey())){
                    j=Math.max(index,j);
                }
                //swap
                char tmp=chars[j];
                chars[j]=chars[i];
                chars[i]=tmp;
                break;
            }else{
                map.get(n).remove(i);
                if(map.get(n).size()==0) map.remove(n);
            }
        }

        String result="";
        for(char c: chars) result+=c;
        return Integer.valueOf(result);
    }
}

