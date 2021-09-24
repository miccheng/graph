package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s=" 3/2 ";
    }
    //1. replace space
    //2. condition to operate: i==len-1|| cur is a sign
    //3. how to operate? look previous sign. num is stored at count,sign is not yet overriden
    //4. after operation, refresh the sign with cur
    public static int calculate(String s) {
        s = s.replaceAll("\\s", "");
        char chars[] = s.toCharArray();

        int len = chars.length;
        int count = 0;
        char symbol = '+';
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (i < len && chars[i] >= '0' && chars[i] <= '9') {
                count = count * 10 + chars[i] - '0';
                i++;
            }
            if (i == len || !Character.isDigit(chars[i])) {
                if (symbol == '+') {
                    stack.push(count);
                } else if (symbol == '-') {
                    stack.push(-count);
                } else if (symbol == '*') {
                    stack.push(stack.pop() * count);
                } else if (symbol == '/') {
                    stack.push(stack.pop() / count);
                }
                if (i < len) {
                    count = 0;
                    symbol = chars[i];
                }
            }

        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
