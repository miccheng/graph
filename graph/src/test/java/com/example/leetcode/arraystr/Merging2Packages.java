package com.example.leetcode.arraystr;

import java.util.HashMap;
import java.util.Map;

public class Merging2Packages {
    // 1 time traverse, searching and has at the same time
    int[] getIndicesOfItemWeights(int[] arr, int limit) {
        if (arr == null || arr.length == 0) return new int[0];
        int len = arr.length;

        Map<Integer, Integer> map = new HashMap<>();//num->index

        //[4,4,1] lim8 return [2,1]
        for (int i = 0; i < len; i++) {
            int n = arr[i];
            int remainder = limit - n;
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                return new int[]{i, index};
            } else {
                map.put(n, i);
            }
        }
        return new int[0];
    }



}
