package com.example.leetcode.recursive.backtracking;

import java.util.*;
import java.util.stream.Stream;

//**With duplicate: Hashmap to avoid choosing the same element in the choice
public class PermutationII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int[][] expected = {{1, 1, 2}, {1, 2, 1}, {2, 1, 1}};
        permuteUnique(nums);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        permuteUniqueRecursive(map, nums.length, result, new ArrayList<Integer>());
        return result;
    }

    private static void permuteUniqueRecursive(Map<Integer, Integer> map,int size, List<List<Integer>> result, List<Integer> path) {
        //base case
        if (path.size()==size) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {//***the entry will always be there
                path.add(key);
                map.put(key, map.get(key) - 1);
                permuteUniqueRecursive(map,size, result, path);

                path.remove(path.size()-1);
                map.put(key, map.get(key) + 1);//***add back to hashmap
            }
        }
    }
}