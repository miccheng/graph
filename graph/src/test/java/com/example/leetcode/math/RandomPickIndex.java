package com.example.leetcode.math;

import java.util.Random;

//Reservoir sampling
public class RandomPickIndex {
    Random rand;
    int[] nums;

    public RandomPickIndex(int[] nums) {
        rand=new Random();
        this.nums=nums;
    }

    public int pick(int target) {
        int result=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=target) continue;
            if(nums[i]==target){
                count++;
                if(rand.nextInt(count)==0){
                    result=i;
                }
            }
        }
        return result;
    }
}
