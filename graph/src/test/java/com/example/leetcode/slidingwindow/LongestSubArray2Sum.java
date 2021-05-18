package com.example.leetcode.slidingwindow;
//like a sliding window problem. two pointers technique
public class LongestSubArray2Sum {
    //minimum-size-subarray-sum is the same problem

    public static void main(String args[]) {
        //find the longest sub array given a sum
        int[] array = {5, 4, 3, 2, 1, 0, 0, 6, 9, 8};
        int sum=15;
        findLongestSubArray(array,sum);
    }

    private static int findLongestSubArray(int[] array, int sum) {
        int len = 0;
        int start = 0;
        int end = 0;
        int result = 0;

        while (end < array.length) {
            result += array[end];
            while (start < end && result > sum) {//pop the start element
                result -= array[start];//result -= array[start++];
                start++;
            }
            if (result == sum && len < end - start + 1) {
                len = end - start + 1;
            }

            end++;
        }

        return len;
    }
}
