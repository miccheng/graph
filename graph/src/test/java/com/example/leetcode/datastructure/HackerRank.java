package com.example.leetcode.datastructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank {
    public static List<Integer> find(List<Character> arr, List<Character> ins) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ins.size(); i++) {
            Character c = ins.get(i);
            for (int j = 0; j < arr.size(); j++) {
                if (c.equals(arr.get(j))) {
                    map.put(c, j);
                    result.add(j);
                    continue;
                }
            }
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        List<Character> arr = new ArrayList<>();
        arr.add('a');
        arr.add('b');
        arr.add('c');

        List<Character> ins = new ArrayList<>();
        ins.add('a');
        ins.add('a');
        ins.add('c');

        find(arr, ins);
    }

}
