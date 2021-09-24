package com.example.leetcode.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if(nums==null||nums.size()==0) return new int []{};
        int len=nums.size();

        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                map.putIfAbsent(i+j, new ArrayList<Integer>());
                map.get(i+j).add(nums.get(i).get(j));
            }
        }
        List<Integer> result=new ArrayList<>();
        for(Integer key: map.keySet()){
            result.addAll(map.get(key));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
