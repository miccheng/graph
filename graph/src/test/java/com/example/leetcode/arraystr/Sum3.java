package com.example.leetcode.arraystr;

import java.util.*;

public class Sum3 {
    //lock down 1 ele and convert the problem to 2sum problem
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        if(nums==null || nums.length==0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]+nums[i]>0){
                    k--;
                } else if(nums[j]+nums[k]+nums[i]<0){
                    j++;
                }else{
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return new ArrayList<>(set);
    }
}
