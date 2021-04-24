package com.example.leetcode.binarysearch;

public class SearchInRotatedArray {

    static int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    static int target=3;

    public static void main(String args[]){
//        int index = findPivot(arr, arr.length, target);
        findSpot(arr, target);
    }


    private static int findSpot(int [] arr, int right) {
        //find pivot
        int end = arr.length - 1;
        int start = 0;
        int pivot=0;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[end]) {/**point out*/
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        //start
         pivot=start;

        //which section it falls in
        int left=0;
        int rightt=arr.length-1;
        if(target>arr[pivot] &&target>arr[right]){
            rightt=pivot-1;
        }else{
            left=pivot;
        }

        //binary serach
         while (left<rightt) {
             int mid = (left + rightt) / 2;
             if (target == arr[mid]) return mid;
             if (target > arr[mid]) {
                 left = mid + 1;
             } else {
                 right = mid -1;
             }
         }

        return -1;
    }

    public static int findPivot(int A[], int n, int target) {
        //find pivot
        int left=0;
        int right=n-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start=left;//pivot
        right=n-1;
        left=0;
        if (target >= arr[start] && target <= arr[right]) {
            left = start;
        } else {
            right = start-1;
        }

        //binary search for ele
        while (left <= right) {
            int mid = left + (right - left) / 2;//integer overflow
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
