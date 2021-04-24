package com.example.leetcode.twopointers;

public class MaxSumArray {
//    kandme algo

   public int findMaxSumArray(int [] arr) {
       int max = arr[0];
       int currentMax = max;
       for (int i = 0; i < arr.length; i++) {
           currentMax = Math.max(max + arr[i], max);//stand alone or to be appended
           max = Math.max(currentMax, max);
       }

       return max;
   }
}
