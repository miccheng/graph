package com.example.leetcode.twopointers.intervals;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result=new ArrayList<>();
        if(nums==null||nums.length==0) {
            result.add(formRange(lower,upper));
            return result;
        }
        //
        if(nums[0]>lower){
            result.add(formRange(lower,nums[0]-1));
        }

        int len=nums.length;
        for(int i=0;i<len-1;i++){
            if(nums[i+1]!=nums[i]+1){
                result.add(formRange(nums[i]+1,nums[i+1]-1));
            }
        }

        if(nums[len-1]<upper){
            result.add(formRange(nums[len-1]+1,upper));
        }

        return result;
    }

    private String formRange(int low, int high){
        return low==high?low+"": low+"->"+high;
    }
}
