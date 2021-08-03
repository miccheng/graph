package com.example.leetcode.arraystr;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int nums[]={23,2,4,6,6};
        int k=7;
        checkSubarraySum(nums,k);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int presum=0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            presum+=nums[i];
            if(map.containsKey(presum%k)){
                if(i-map.get(presum%k)>=2) return true;
            }else{
                map.put(presum%k,i);
            }
        }
        return false;
    }
}
