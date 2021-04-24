package com.example.leetcode.datastructure;

import java.util.ArrayDeque;

public class ValidParenthese {
//  Input: s = ")()())", Output: 4
    public static void main(String args[]) {
//        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.getFirst());
//        System.out.println(stack.getLast());
        System.out.println(longestValidParentheses("()(()"));
    }

    //Input: s = "())(())"
    public static int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);//breaks here. not consecutive
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }


    public static int longestValidParenthesesE(String s) {
        int n = s.length(), longest = 0;
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.isEmpty()) {//current is ')'
                    if (s.charAt(st.getFirst()) == '(') st.pop();//found a pair
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.isEmpty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.isEmpty()) {
                b = st.getFirst(); st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }


}
