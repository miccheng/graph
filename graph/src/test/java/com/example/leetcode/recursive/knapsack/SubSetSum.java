package com.example.leetcode.recursive.knapsack;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        int arr[]={1,3,-4};
        List<List<Integer>> list = subsetWithZero(arr, 0, 0, 0);


        int nums[]={1,3,4,5,7};
        List<List<Integer>> result=new ArrayList<>();
        knapsackRecursiveMemo(nums,0,new  ArrayList<Integer>(), result,7);

        boolean[][] dp=new boolean[nums.length+1][8];
        boolean res= knapsackTopdown(nums,0,7,dp );
        System.out.println();
    }

//    Number of subsets with negative numbers. only recursive would work here?
    public static List<List<Integer>> subsetWithZero(int arr[],int start,int sum, int targetSum) {
        List<List<Integer>> result = Lists.newArrayList();
        //base case
        if (sum == targetSum && start != 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        if (start >= arr.length) return result;
        //body
        List<List<Integer>> list1 = subsetWithZero(arr, start + 1, sum + arr[start], targetSum);
        list1.forEach(e->e.add(arr[start]));

        List<List<Integer>> list2 = subsetWithZero(arr, start + 1, sum, targetSum);

        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static void knapsackRecursiveMemo(int arr[], int start, List<Integer> path, List<List<Integer>> result, int targetSum) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (start >= arr.length || targetSum < 0) return;

        List<Integer> withCurrent = new ArrayList<>(path);
        withCurrent.add(arr[start]);

        int remain = targetSum - arr[start];
        if (targetSum >= arr[start]) knapsackRecursiveMemo(arr, start + 1, withCurrent, result, remain);
        knapsackRecursiveMemo(arr, start + 1, path, result, targetSum);
    }

    public static boolean knapsackTopdown(int arr[], int start, int targetSum, boolean[][] dp) {
        if (targetSum == 0) {
            return true;
        }
        if (start >= arr.length || targetSum < 0) return false;

//        if(dp[][])
        int remain = targetSum - arr[start];
        boolean flag = false;
        if (targetSum >= arr[start]) {
            flag = knapsackTopdown(arr, start + 1, remain,dp);
        }
        return flag || knapsackTopdown(arr, start + 1, targetSum,dp);
    }

    
}
