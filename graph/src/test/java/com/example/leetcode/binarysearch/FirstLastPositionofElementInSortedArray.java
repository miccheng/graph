package com.example.leetcode.binarysearch;

public class FirstLastPositionofElementInSortedArray {
    //left most ele and right most ele
    public static void main(String args[]) {
        int target = 8;
        int arr[] = {5, 7, 7, 7, 8, 8, 8, 10};
        findPositions(target, arr);
        System.out.println();
    }

    private static int[] findPositions(int target, int[] arr) {
        int[] result = new int[2];
        int left = 0;
        int right = arr.length - 1;
        //left most
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        result[0] = left;

        //right most
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target >= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        result[1] = end - 1;
        return result;
    }
}