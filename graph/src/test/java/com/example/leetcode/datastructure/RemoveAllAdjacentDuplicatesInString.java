package com.example.leetcode.datastructure;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;
import java.util.stream.Collectors;
//crush candy problem
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        removeDuplicates(s, k);
        String expected = "aa";
    }

    //option: can use 2 stacks, 1 for char occurrence, the other for char
    public static String removeDuplicates(String s, int k) {
        LinkedList<Adj> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().freq++;
            } else {
                stack.push(new Adj(c, 1));
            }
            //check k
            if (stack.peek().freq == k) stack.pop();
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() > 0) {
            char c = stack.pop().ch;
            int freq = stack.pop().freq;
            for (int i = 0; i < freq; i++) {
                stringBuilder.append(c + "");
            }
        }
        return stringBuilder.toString();
    }



    static class Adj {
        char ch;
        int freq;

        public Adj(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeDuplicates2Poniters(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = (i > 0 && stack[i - 1] == stack[j]) ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }


}
