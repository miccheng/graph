package com.example.leetcode.strchar;

import java.util.stream.Stream;

public class StringPrefix {

    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        String[] prefixes = {"Geeks", "or", "Gfor"};
    }

    public boolean prefixSearch(String s, String [] prefixes) {
        boolean b = Stream.of(prefixes).anyMatch(s::startsWith);
        return b;
    }
}
