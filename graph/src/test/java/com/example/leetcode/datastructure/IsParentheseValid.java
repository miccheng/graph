package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsParentheseValid {
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
//    determine if the input string is valid. "{[()]}"

    public static void main(String args[]) {
//        "([}}])"
        String s = "(]{}])";
        isValid(s);
    }

    //think positive case
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if ('}' == c && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (']' == c && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (')' == c && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else{//***super important
                return false;
            }

        }

        return stack.isEmpty();
    }

    //without using stack
    public static boolean isValidd(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(') return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[') return false;
                    break;
            }
        }
        return head == 0;

    }
}
