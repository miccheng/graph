package com.example.leetcode.datastructure;

import java.util.LinkedList;

public class AdjacentDuplicates {
    public static void main(String[] args) {
        String input="deeedbbcccbdaa";
        int k=3;
        removeDuplicates(input,k);
    }

    public static String removeDuplicates(String s, int k) {
        char chars[]=s.toCharArray();
        LinkedList<Pair> stack=new LinkedList<>();
        int i=0;
        int len=chars.length;
        while(i<len){
            if(!stack.isEmpty()&& stack.peek().c==chars[i]){
                if(stack.peek().count+1==k){
                    stack.pop();
                }else{
                    Pair top = stack.peek();
                    top.count= top.count+1;
                }
            }else{
                stack.push(new Pair(chars[i],1));
            }
            i++;
        }

        String result="";
        while(!stack.isEmpty()){
            Pair p=stack.pollLast();
            for(int j=0;j<p.count;j++){
                result+=p.c;
            }
        }

        return result;
    }


    static class Pair{
        char c;
        int count;

        public Pair(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
}
