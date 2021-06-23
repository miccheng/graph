package com.example.leetcode.recursive.backtracking;

import java.util.PriorityQueue;
import java.util.Queue;

public class PartitionKSubsets {
    public static void main(String[] args) {
        int [] nums = {4,3,2,3,5,2,1};
        int k = 4;
//        int [] nums = {1,2,3,4};
//        int k =4;
        canPartitionKSubsets(nums,k);
    }


    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % k != 0 || maxNum > sum / k) {
            return false;
        }
        return can(nums, k, new boolean[nums.length], sum / k, 0, 0);
    }

    private static boolean can(int[] nums, int k, boolean[] visited, int target, int sum, int start) {
        if (k == 1) return true;

        if (sum == target) {
            return can(nums, k - 1, visited, target, 0, 0);
        }
        if (sum > target) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (can(nums, k, visited, target, sum + nums[i], i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }


}

