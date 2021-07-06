package com.example.leetcode.arraystr;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        subarraySum(nums, k);

    }

    //usage of prefix sum and map
    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int cur : nums) {
            sum += cur;
            if (map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                count += map.get(sum - k);//**** increment should be its frequence stored in map instead of +1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }




}
