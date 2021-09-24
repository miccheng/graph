package com.example.leetcode.twopointers.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if(nums==null||nums.length==0) return result;

        int len=nums.length;
        int i=0;
        int j=0;
        while(j<len){
            while(j<len-1&&nums[j]+1==nums[j+1]){
                j++;
            }
            result.add(rangeForm(nums[i], nums[j]));
            j++;
            i=j;
        }
        return result;
    }

    private String rangeForm(int low, int high){
        return low==high?low+"":low+"->"+high;
    }
}
