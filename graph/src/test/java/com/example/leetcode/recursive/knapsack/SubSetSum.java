package com.example.leetcode.recursive.knapsack;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        int arr[]={1,3,-4};
        List<List<Integer>> list = subsetWithZero(arr, 0, 0, 0);
        System.out.println();

    }
    //diff from the regular can sum unbounded or coin change pri=oblem . the ele can't be reused
//    canSum(i,result,targetSum)= canSum(i+1,result+arr[i+1],targetSum)||canSum(i+1,result,targetSum)
    //base case:
//    targetSum==result return true;
//    i> arr.length || result> sum return false


    //dp solution



//    Number of subsets with negative numbers. only recursive would work here?
    public static List<List<Integer>> subsetWithZero(int arr[],int index,int sum, int targetSum) {
        List<List<Integer>> result = Lists.newArrayList();
        //base case
        if (sum == targetSum && index != 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        if (index >= arr.length) return result;
        //body
        List<List<Integer>> list1 = subsetWithZero(arr, index + 1, sum + arr[index], targetSum);
        list1.forEach(e->e.add(arr[index]));

        List<List<Integer>> list2 = subsetWithZero(arr, index + 1, sum, targetSum);

        result.addAll(list1);
        result.addAll(list2);
        return result;
    }


}
