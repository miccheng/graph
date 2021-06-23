package com.example.leetcode.recursivedp;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class CoinsChange {
    private static 
    Map<Integer, Integer> map=new HashMap<>();

    public static void main(String[] args) {
        int asInt = map.entrySet().stream().mapToInt(Map.Entry<Integer, Integer>::getValue).max().getAsInt();
    }


}
