package com.example.leetcode.recursivestring;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {
//    Input: s = "3[a2[c]]"
//    Output: "accaccacc"
public static void main(String[] args) {
        String s="3[a2[c]]";
        decodeString2(s);
}
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
                while(Character.isDigit(alphabets.peek())){
                    count=count*10+alphabets.poll()-'0';
                }
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

    public static String decodeString2(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
