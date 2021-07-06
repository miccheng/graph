package com.example.leetcode.arraystr;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//*****Kadane's Algorithm
public class MaxProductSubarray {
    public static void main(String[] args) {
        int arr[] = {3,-2,4,5};
        maxProduct(arr);
    }

    //keep track of both min and max
    public static int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int prefix=1;

        int prefix_min=1;
        int prefix_max=1;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            if(cur==0){
                prefix_min=0;
                prefix_max=0;
            }else{
                int tmp_min=prefix_min;
                int tmp_max=prefix_max;

                prefix_min=Math.min(cur, tmp_min*cur);
                prefix_min=Math.min(prefix_min,tmp_max*cur);

                prefix_max=Math.max(cur, tmp_min*cur);
                prefix_max=Math.max(prefix_max,tmp_max*cur);
            }
            max=Math.max(prefix_max,max);
        }

        return max;
    }
}
