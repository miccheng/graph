package com.example.leetcode.arraystr;

import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    //    https://leetcode.com/problems/number-of-matching-subsequences/
    //map+queue
    public static void main(String[] args) {
        char [] array1={'1','2','3'};
        char [] array2={'1','2','3'};
        Map<char[], List<String>> map = new HashMap<>();
        map.put(array1, Arrays.asList("1", "2", "3"));
        map.put(array2, Arrays.asList("1", "2", "3"));

        boolean equals = Arrays.equals(array1, array2);
        System.out.println();
    }
}
