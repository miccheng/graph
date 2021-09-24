package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.HashSet;

public class BasicCaculator {
    public static void main(String[] args) {
        String s="- (3 + (4 + 5))";
        calculate(s);
    }
    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char chars[] = s.replaceAll("\\s", "").toCharArray();
        int len = chars.length;
        int count = 0;
        int result = 0;
        int sign = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (i < len && Character.isDigit(chars[i])) {
                count = count * 10 + chars[i] - '0';
                i++;
            }
            result += count * sign;
            count = 0;
            if (i < len) {
                if (chars[i] == '+') {
                    sign = 1;
                } else if (chars[i] == '-') {
                    sign = -1;
                } else if (chars[i] == '(') {
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                } else if (chars[i] == ')') {
                    result = stack.pop() * result + stack.pop();
                }
            }
        }

        return result;
    }
}
