package com.example.leetcode.binarysearch.range;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 6, 2};
        mergeSort(arr,4);
    }
//*** args: len
    public static void mergeSort(int[] a, int n) {
        //divide till only 1 ele in the array
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }


    public static void merge(int[] a, int[] l, int[] r, int leftLen, int rightLen) {
        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < leftLen) {
            a[k++] = l[i++];
        }
        while (j < rightLen) {
            a[k++] = r[j++];
        }
    }

}
