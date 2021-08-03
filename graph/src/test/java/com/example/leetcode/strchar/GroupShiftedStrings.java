package com.example.leetcode.strchar;

import java.util.*;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result=new ArrayList<>();
        if(strings==null||strings.length==0) return result;
        Map<String, List<String>> map=new HashMap<>();

        for(String str:strings){
            String key=getKey(str);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        for(String key: map.keySet()){
            List<String> group=map.get(key);
            Collections.sort(group);
            result.add(group);
        }

        return result;
    }

    private String getKey(String str){
        int len=str.length();
        String key="";
        for(int i=1;i<len;i++){
            int dis=str.charAt(i)-str.charAt(i-1);
            if(dis<0) dis+=26;
            key+=dis+",";
        }
        return key;
    }
}
