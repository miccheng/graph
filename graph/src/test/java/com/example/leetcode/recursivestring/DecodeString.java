package com.example.leetcode.recursivestring;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DecodeString {
//    Input: s = "3[a2[c]]"
//    Output: "accaccacc"
    public String decodeString(String s) {
        if(s==null|| s.length()==0) return "";
        int len=s.length();
        Queue<Character> alphabets=new LinkedList<>();
        for(char c:s.toCharArray()){
            alphabets.offer(c);
        }
        return recursive(alphabets);
    }
//    Every time we meet a '[', we treat it as a subproblem so call our recursive function to get the content in that '[' and ']'. After that, repeat that content for 'num' times.
//    Every time we meet a ']', we know a subproblem finished and just return the 'word' we got in this subproblem.
    public String recursive(Queue<Character> alphabets){
        int count=0;
        String prefix="";
        while(!alphabets.isEmpty()){
            char c=alphabets.poll();
            if(Character.isDigit(c)){
                count=count*10+c-'0';
            }else if(Character.isLetter(c)){
                prefix+=c+"";
            }else if(c=='['){
                String prev=recursive(alphabets);
                prefix+=String.join("", Collections.nCopies(count,prev));
                count=0;
            }else{//"]"
                return prefix;
            }
        }

        return prefix;
    }
}
