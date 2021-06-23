package com.example.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int arr[]={1,1,1}; int k = 2;
        subarraySum(arr,k);
    }

// Solution 1: use map to memorize previous prefix sum
    public int subarraySumMap(int[] nums, int k) {
        int count=0;
        Map<Integer, Integer> map=new HashMap<>();//sum-->frequency
        map.put(0,1);//****initialize
        int sum=0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }


        return count;
    }


    //Solution 2: 2 pointers
    public static int subarraySum(int[] nums, int k) {
        int count=0;

        for(int i=1; i<nums.length;i++){
            nums[i]+=nums[i-1];
        }

        for(int i=0;i<nums.length; i++ ){
            if(nums[i]==k){count++;}
            int j=i+1;

            while(j<nums.length){
                int sum=nums[j]-nums[i];
                if(sum==k){
                    count++;
                }
                j++;
            }
        }
        return count;

    }
}
