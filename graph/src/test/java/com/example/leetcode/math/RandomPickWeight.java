package com.example.leetcode.math;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomPickWeight {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        RandomPickWeight pickWeight = new RandomPickWeight(new int[]{1, 2, 3});
    }

    int sum =0;
    TreeMap<Integer, Integer> map= new TreeMap<>();
    Random rnd= new Random();
    public RandomPickWeight(int[] w) {
        for (int i=0; i<w.length; i++){
            sum +=w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        // int key= map.ceilingKey(rnd.nextInt(cnt)+1); don't forget to +1, because rand.nextInt(cnt) generate random integer in range [0,cnt-1]
//        [0,cnt)
        int key= map.higherKey(rnd.nextInt(sum));
        return map.get(key);
    }
}
