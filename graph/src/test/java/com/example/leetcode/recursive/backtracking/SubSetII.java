package com.example.leetcode.greedy.random.backtracking;


import java.util.ArrayList;
import java.util.List;

public class SubSetII {
    //subset set without duplicate
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generateSub(0,nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void generateSub(int index,int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {
        //base case
        result.add(new ArrayList<>(path));

        for (int j = index; j < nums.length; j++) {
//            if(j > index && nums[i] == nums[i-1]) continue; // skip duplicates
            path.add(nums[j]);
            generateSub(j+1,nums,path,result);
            path.remove(path.size()-1);
        }

    }

    //subset with duplicate

}
