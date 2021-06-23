package com.example.leetcode.recursivedp;

import java.util.ArrayList;
import java.util.List;

public class SumProblem {
    public static void main(String args[]){
        int targetSum=7;
        int arr[]={2,3,6,7};
        List<List<Integer>> result = howSumTree(targetSum, arr);

        miniSubarray(arr, targetSum);
//        int targetSum=7;
//        int arr[]={3,4,5};
//        canSumTabulation(targetSum, arr);
    }

    private static boolean canSumTree(int targetSum, int[] arr) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int i = 0; i < arr.length; i++) {
            int left = targetSum - arr[i];
            if (canSumTree(left, arr) == true) return true;
        }
        return false;
    }

    private static boolean canSumTabulation(int targetSum, int[] arr) {
        boolean dp[] = new boolean[targetSum + 1];
        dp[0] = true;
        for (int i = 0; i < targetSum + 1; i++) {//***use targetSum + 1
            if (dp[i] == true) {
                for (int j = 0; j < arr.length; j++) {
                    int num = arr[j];
                    if (i + num <= targetSum) dp[i + num] = true;
                }
            }
        }
        return dp[targetSum];
    }


    private static List<List<Integer>> howSumTree(int targetSum, int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (targetSum == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        if (targetSum < 0) return null;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int remainder = targetSum - current;
            List<List<Integer>> remainderResult = howSumTree(remainder, arr);
            if (remainderResult != null) {//early return of the how
                remainderResult.stream().forEach(e -> e.add(current));
                result.addAll(remainderResult);
            }
        }
        return result;
    }

    private static List<Integer> howSumTabulation(int targetSum, int[] arr) {
        List<Integer> dp[] = new List[targetSum + 1];
        dp[0] = new ArrayList<Integer>();
        for (int i = 0; i < targetSum + 1; i++) {//***use targetSum + 1
            if (dp[i] != null) {
                for (int j = 0; j < arr.length; j++) {
                    int num = arr[j];
                    if (i + num <= targetSum) {
                        List<Integer> list = new ArrayList<>(dp[i]);
                        list.add(arr[j]);
                        dp[i + num] = list;
                    }
                }
            }
        }
        return dp[targetSum];
    }


    //Min length of subarray exceeding the target sum
    public static int miniSubarray(int [] arr, int target) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum > target) {
                    length = Math.min(length, j - i + 1);
                }
            }
        }
        if (length == Integer.MAX_VALUE) {
            return -1;
        }
        return length;
    }
}
