package com.example.leetcode.recursivedp;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int nums[]={1,2,4,3};
        lengthOfLISGlo(nums);
    }
    //Solution 1: DFS + Thinking it as making a choice
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        return recursion(nums, nums.length, 0,Integer.MIN_VALUE, new HashMap<Integer, Integer>());
    }

    public int recursion(int nums[], int len, int start,int previous, Map<Integer, Integer> map){
        if(start>=len) return 0;

        int current=nums[start];
        int take=0;
        if(current>previous){
            if(!map.containsKey(start)){
                map.put(start,recursion(nums, len, start+1, current, map)+1);
            }
            take=map.get(start);
        }

        int leave=recursion( nums,  len,  start+1, previous, map);
        return Math.max(take,leave);

    }

    //Solution2: Test each ele as the 1st ele of the sub sequence + DFS
    //Russian doll envelope


    //Solution 3:
    public static int findLIS(int [] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }

    //variation of solution 1: DFS with global variable
    //can't transform to DP tables as the structure is not method based
    private static int max=Integer.MIN_VALUE;

    public static int lengthOfLISGlo(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        recursion(nums, nums.length, 0,Integer.MIN_VALUE,0 );

        return max;
    }

    public static void recursion(int nums[], int len, int start,int previous,int count) {
        if (start >= len) {
            max = Math.max(max, count);
            return;
        }
        int current=nums[start];
        if (current > previous) {
            recursion(nums, len, start + 1, current, count + 1);
            recursion(nums, len, start + 1, previous, count);
        } else {
            recursion(nums, len, start + 1, previous, count);
        }
    }
}
