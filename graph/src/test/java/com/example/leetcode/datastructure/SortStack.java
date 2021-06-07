package com.example.leetcode.datastructure;

import java.util.Stack;

public class SortStack {
    //we can stack1 by inserting ele from s1 into the right place of s2. How do we find the right place?
    public void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Integer tmp = s1.peek();
            while (!s2.isEmpty() && s2.peek()>tmp) {
                s1.push(s2.pop());
            }
            s2.push(s1.pop());
        }

        //copy s2 back to s1
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
}
