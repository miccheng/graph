package com.example.leetcode.binarysearch;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int [] citations = {3,0,6,1,5};
       // binarySearchHIndex(citations);
        //findHIndex(citations);
        countSortHIndex(citations);
    }

    //counting sort would be more straight forward
    public static int countSortHIndex(int[] citations) {
        int n = citations.length;
        int count[] = new int[7];
        for (int cita : citations) {
            count[cita]++;
        }
        for (int i = 1; i < 7; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int shifted[] = new int[7];
        shifted[0] = 0;
        System.arraycopy(count, 0, shifted, 1, n);

        for (int i = n; i >= 0; i--) {
            if (i == n + 1 - shifted[i])
                return i;
            else if (i > n + 1 - shifted[i])
                i--;
        }
        return -1;
    }

    //binary search
    public static int binarySearchHIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid)
                return citations[mid];
            else if (citations[mid] >= len - mid)
                right = mid - 1;
            else
                left = mid + 1;

        }
        //*** trick
        return len - left;
    }


    //bucket sort
    public static int findHIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
