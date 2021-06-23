package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result=new ArrayList<>();

        backtrack(k,n,nums,0,new ArrayList<Integer>(), result);
        return result;
    }

    public void backtrack(int k,int target, int nums[],int start, List<Integer> path, List<List<Integer>> result){
        if(target==0&&path.size()==k){
            result.add(new ArrayList<Integer>(path));
            k--;
            return;
        }
        if(target<0){
            return;
        }

        if(path.size()>k){
            return;
        }

        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            int remain=target-nums[i];
            backtrack(k,remain,nums, i+1,path,result);
            path.remove(path.get(path.size()-1));
        }

    }


}
