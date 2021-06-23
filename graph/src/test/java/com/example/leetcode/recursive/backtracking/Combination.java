package com.example.leetcode.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    //{1,2,3} combination of 3 numbers
    //{1,2,3} combination of 2 numbers
    //C(n,r)=n! (n−r)! r!, among n numbers draw r numbers
    public static void main(String[] args) {
        combine(3,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList(), n, k,1);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k,int num){
        if(tempList.size() == k){
            res.add(new ArrayList(tempList));
            return;
        }

        for(int i=num; i<=n; i++){
            tempList.add(i);
            backtrack(res,tempList,n,k,i+1);//use i+1 to make sure it doesn't go back
            tempList.remove(tempList.size()-1);
        }
    }
}
