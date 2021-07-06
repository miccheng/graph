package com.example.leetcode.recursive.knapsack;

public class PartitionKSubsets {
    public static void main(String[] args) {
        int []nums = {4,3,2,3,5,2,1};
        int k = 4;
        canPartitionKSubsets(nums,k);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums==null || nums.length==0) return false;
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        if(sum%k!=0) return false;

        int target=sum/k;
        int len=nums.length;
        int [][] dp=new int[len+1][target+1];

        for(int i=0;i<=len;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=len;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]+=dp[i-1][j];
                if(j>=nums[i-1]) dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }

        return dp[len][target]==k;
    }
}
