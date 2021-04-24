package com.example.leetcode.datastructure;

import java.util.HashMap;

public class IndexNumArray {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 5, 6, 4, -3, 2};
        shuffleArray(arr);
    }

    private static void shuffleArray(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();//index value mapping
        int max = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = arr[i] >= 0 && arr[i] <= max ? true : false;
            map1.put(i, arr[i]);
            map.put(arr[i], flag);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(i) && map.get(i) == true) {
                arr[i] = i;
            } else {
                int index = i;
                while (map.containsKey(map1.get(index))) {
                    index = map1.get(index);
                }
                arr[i] = map1.get(index);
            }
        }
        System.out.println(arr);
    }

}
