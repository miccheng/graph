package com.example.leetcode.arraystr;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//num-->index
        Map<Integer, Integer> map2 = new HashMap<>();//num-->fre

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int remain = target - current;
            map2.put(current, map2.get(current) - 1);
            if (map2.getOrDefault(remain, 0) != 0) {
                indices[0] = i;
                indices[1] = map.get(remain);
                return indices;
            }
            map2.put(current, map2.get(current) + 1);
        }
        return indices;
    }

}
