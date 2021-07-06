package com.example.leetcode.recursivestring;

public class MagicIndex {
    public static void main(String[] args) {
        int arr[]={-10,-5,2,2,2,3,4,7,9,12,13};
        findMagicIndexNonDistinct(0, arr.length-1, arr);
    }

    //Scenario 1: distinct number
    public int magicFast(int[] array) {
        return findMagicIndex(0, array.length, array);
    }

    private int findMagicIndex(int start, int end, int[] array) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] < mid) {
            return findMagicIndex(mid + 1, end, array);
        } else {
            return findMagicIndex(start, mid - 1, array);
        }
    }

    //Scenario 2: non distinct number
    private static int findMagicIndexNonDistinct(int start, int end, int[] array) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        int midVal = array[mid];
        if (midVal == mid) {
            return mid;
        }
        int bound2 = Math.min(midVal, mid - 1);
        int left = findMagicIndexNonDistinct(start, bound2, array);
        if (left >= 0) return left;

        int bound1 = Math.max(midVal, mid + 1);
        return findMagicIndexNonDistinct(bound1, end, array);
    }

}