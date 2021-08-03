package com.example.leetcode.arraystr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
    }

    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0) return new int[]{};
        int len=nums.length;
        int [] result=new int[len];

        int front[]=new int[len];
        Arrays.fill(front,1);


        for(int i=1; i<len;i++){
            front[i]=front[i-1]*nums[i-1];
        }

        int suffix=1;
        for(int j=len-2;j>=0;j--){
            suffix*=nums[j+1];
            front[j]*=suffix;
        }

        return front;
    }
}
