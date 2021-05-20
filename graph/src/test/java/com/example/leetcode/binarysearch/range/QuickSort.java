package com.example.leetcode.binarysearch.range;

public class QuickSort {
    public static void quicksort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    public static void qs(int[] arr, int l, int r) {
        if (l >= r) {//empty or 1 element only
            return;
        }
        int p = partition(arr, l, r);

        qs(arr, l, p - 1);//left
        qs(arr, p + 1, r);//right
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //put pivot in the middle
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }


}
