package com.example.leetcode.datastructure;

import java.util.*;

public class SimplifyPath {
    public static void main(String[] args) {
        String s="/home//foo/";
        String[] split = s.split("/");
        simplifyPath(s);
    }

    public static String simplifyPath(String path) {
        if(path==null) return " ";
        String splits[]=path.split("/");

        int len=splits.length;
        Deque<String> stack=new LinkedList<>();
        Set<String> invalids=new HashSet<>(Arrays.asList(".","_",".."," "));
        for(int i=0;i<len;i++){
            String current=splits[i];
            if("..".equals(current)&&!stack.isEmpty()){
                stack.pop();
            }else if(!invalids.contains(current)){
                stack.push(current);
            }
        }
        //*** when nothing, return "/"
        String result="";
        while(!stack.isEmpty()){
            result+="/"+stack.pollLast();
        }
        return "".equals(result)?"/": result;
    }
}
