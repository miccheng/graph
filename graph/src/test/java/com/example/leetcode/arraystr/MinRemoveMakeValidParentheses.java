package com.example.leetcode.arraystr;

import java.util.*;

public class MinRemoveMakeValidParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        minRemoveToMakeValid(s);
    }

    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return "";

        Deque<Integer> stack = new ArrayDeque<>();
        char letters[] = s.toCharArray();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (c == ')') {
                set.add(i);
            }
        }

        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (!set.contains(i)) {
                builder.append(letters[i] + "");
            }
        }
        return builder.toString();
    }

    //  while (!st.empty())
    //    sb.setCharAt(st.pop(), '*');
    //  return sb.toString().replaceAll("\\*", "");
}
