package com.example.leetcode.datastructure;

import java.util.*;

public class TopKFrequentEle {
    //Solution 1:
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            heap.add(e);
        }

        int counter = 1;
        while (counter <= k) {
            result[counter - 1] = heap.poll().getKey();
            counter++;
        }


        TreeMap<Object, Object> treeMap = new TreeMap<>();
        TreeMap<Integer, List<Integer>> map2=new TreeMap<>();
        List<Integer> numbers= map2.pollLastEntry().getValue();

        return result;
    }

//Solution 2
    public int[] topKFrequentTreeMap(int[] nums, int k) {
        int [] result= new int[k];
        Map<Integer, Integer> map=new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap=new TreeMap<>();

        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            Integer num=e.getKey();
            Integer fre=e.getValue();

            if(!treeMap.containsKey(fre)){
                List<Integer> tmp=new ArrayList<>();
                treeMap.put(fre,tmp);
            }
            treeMap.get(fre).add(num);


        }


        int counter=1;
        while(counter<=k){
            List<Integer> numbers= treeMap.pollLastEntry().getValue();
            for(int n: numbers){
                result[counter-1]=n;
                counter++;
            }
        }

        return result;
    }
}
