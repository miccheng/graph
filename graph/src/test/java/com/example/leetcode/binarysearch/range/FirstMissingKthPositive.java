package com.example.leetcode.binarysearch.range;

public class FirstMissingKthPositive {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 7,11};
        findKthPositive(arr,6);
    }

    //find the mini value that is just > k
    public static int findKthPositive(int[] arr, int k) {
        if(arr[0]>k) return k;//missing number not in the array
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) < k)
                l = mid+1;
            else
                r = mid-1;
        }
        return l + k;
    }
}