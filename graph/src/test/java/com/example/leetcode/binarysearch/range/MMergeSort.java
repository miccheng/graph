package com.example.leetcode.binarysearch.range;

public class MMergeSort {
    public void mergeSort(int arr[]) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int beg, int end) {
        if (beg >= end) return;
        int mid = beg + (end - beg) / 2;
        mergeSort(arr, temp, beg, mid);
        mergeSort(arr, temp, mid + 1, end);

        merge(arr, temp, beg, end);
    }

    private void merge(int[] arr, int[] temp, int beg, int end) {
        int mid = (beg + end) >>> 2;
        int i = beg;
        int leftEnd = mid;
        int j = mid + 1;
        int index = beg;

        while (i <= leftEnd && j <= end) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }

        System.arraycopy(arr, i, temp, index, mid - i + 1);
        System.arraycopy(arr, j, temp, index, end - j + 1);
        System.arraycopy(temp, beg, arr, beg, end - beg + 1);
    }
}
