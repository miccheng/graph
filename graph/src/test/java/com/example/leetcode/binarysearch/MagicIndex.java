package com.example.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MagicIndex {
    public static void main(String[] args) {
        int arr[] = {-10, -5, 2, 2, 2, 3, 7, 7, 9, 10, 10};
        List<Integer> result = new ArrayList<Integer>();
        magicFast(arr, 0, arr.length - 1, result);
        System.out.println();
    }

    public static void magicFast(int[] array, int start, int end, List<Integer> result) {
        if (start > end) return;
        int midIndex = start + (end - start) / 2;
        int midVal = array[midIndex];

        if (midIndex == midVal) {
            result.add(midIndex);
            return;
        }

        //search left
        int leftIndex = Math.min(midIndex - 1, midVal);
        magicFast(array, start, leftIndex, result);
//        if (left >= 0) return left;

        int rightIndex = Math.max(midIndex + 1, midVal);
        magicFast(array, rightIndex, end, result);
//        return right;
    }
}
