package com.example.leetcode.twopointers;

public class TrapRainWater {
    public static void main(String args[]){
        int rain[]={4,2,0,3,2,5};
        accumulateWater(rain);
    }

    private static int accumulateWater(int[] rain) {
        int bucket = 0;
        int start = 0;
        int end = rain.length - 1;
        int left = rain[0];
        int right = rain[end];
        while (start < end) {
            if (left < right) {
                start++;
                int next = rain[start];
                if (next <= left) {
                    bucket += left - next;
                } else {
                    left = next;
                }
            } else {
                end--;
                int next = rain[end];
                if (next <= right) {
                    bucket += right - next;
                } else {
                    right = next;
                }
            }
            System.out.println();
        }
        return bucket;
    }
}
