package com.example.leetcode.arraystr;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    //longest subarray of a binary array with equal numbers of 0 and 1
    //The idea is to change 0 in the original array to -1
    public int findMaxLength(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);

        int sum=0;
        int max=0;
        for(int i=0;i< nums.length;i++){
            sum+=(nums[i]==0)?-1:1;
            if(map.containsKey(sum)){
                max=Math.max(i-map.get(sum),max);
            }else{
                map.put(sum,i);
            }
        }

        return max;
    }

}
