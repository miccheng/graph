package com.example.leetcode.datastructure;

import org.assertj.core.util.Maps;

import java.util.*;
//preserve the insertion order of a map
public class ContinuousSegment {
    public static void main(String args[]) {
        Map<Integer, Integer> map = Maps.newHashMap(4, 5);
        map.put(11, 9);
        map.put(9, 4);
        map.put(5, 6);
        map.put(6, 1);
        sort(map);
    }

    public static void sort(Map<Integer,Integer> map) {
        Integer maxKey = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
//        map.keySet().stream().max(Integer::compareTo).get();
        Integer nextKey = map.get(maxKey);
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        resultMap.put(maxKey, nextKey);
        for (int i = 0; i < map.size() - 1; i++) {
            resultMap.put(nextKey, map.get(nextKey));
            nextKey = map.get(nextKey);
        }
        System.out.println(resultMap);
    }

}
