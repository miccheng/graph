package com.example.leetcode.arraystr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum3Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;
        int count=0;

        for(int i=0;i<len;i++){
            int j=i+1;
            int k=len-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<target){
                    count+=k-j;
                    j++;
                }else{
                    k--;
                }
            }
        }
        return count;
    }
}
