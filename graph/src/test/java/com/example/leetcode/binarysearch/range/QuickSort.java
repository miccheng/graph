package com.example.leetcode.binarysearch.range;

public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[start];
        int index = partition(arr, start, end, pivot);
        quickSort(arr, start, index);
        quickSort(arr, index + 1, end);
    }

    //swap the ele to make smaller appear before bigger
    private int partition(int[] arr, int start, int end, int pivot) {
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {//***must apply before sort
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        String a="";
        a.startsWith("0");
        return i - 1;
    }
}
