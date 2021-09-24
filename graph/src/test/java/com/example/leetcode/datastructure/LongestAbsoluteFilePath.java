package com.example.leetcode.datastructure;

import java.util.ArrayDeque;

public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        String input="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        lengthLongestPath(input);
    }

    public static int lengthLongestPath(String input) {
        if(input==null|| input.length()==0) return 0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        String [] paths=input.split("\n");

        int max=0;
        stack.push(0);
        for(int i=0;i<paths.length;i++){
            String cur=paths[i];
            int tabs=cur.lastIndexOf("\t")+1;
            int level=tabs+1;
            while(stack.size()>level){
                stack.pop();
            }
            int curLen=stack.peek()+cur.length()-tabs+1;
            stack.push(curLen);
            if(cur.contains(".")) max=Math.max(curLen-1,max);
        }
        return max;
    }
}
