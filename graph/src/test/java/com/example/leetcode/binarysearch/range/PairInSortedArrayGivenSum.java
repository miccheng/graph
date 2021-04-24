package com.example.leetcode.binarysearch.range;

public class PairInSortedArrayGivenSum {
    //    Given a sorted and rotated array, find if there is a pair with a given sum
    public static void main(String args[]){
        int arr[]={11, 15, 6, 8, 9, 10};
        pairInSortedRotated(arr,26);
        findPivot(arr);
    }

    public static boolean pairInSortedRotated(int arr[], int x) {
        int count = 0;
        int pivot = findPivot(arr);
        int pointer1 = pivot-1;
        int pointer2 = pivot;
        int result[] = new int[2];
        while (pointer1 != pointer2) {
            if (pointer1 < 0) pointer1 = pointer1 +arr.length;//***out of bound
            if (pointer2 > arr.length - 1) pointer2 = pointer2 - arr.length;//***out of bound
            int sum = arr[pointer1] + arr[pointer2];
            if (sum < x) {
                pointer2++;
            } else if (sum == x) {
                count++;
                result[0] = pointer1;
                result[1] = pointer2;
                return true;
            } else {
                pointer1--;
            }
        }
        return false;
    }

    private static int findPivot(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid +1;
            } else {//right is sorted
                right = mid;
            }
        }

        return left;
    }
}
