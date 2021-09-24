package com.example.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    public static void main(String[] args) {
        int arr[]={0,0,1,2,3,3,4,7,7,8};
        findClosestElements2(arr,3,5);
    }
    //solution 1: find the start element
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len=arr.length;
        int left=0;
        int right=len-k;


        while(left<right){//left close, right open
            int mid=left+(right-left)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return Arrays.stream(arr, left, left+k).boxed().collect(Collectors.toList());
    }

    //Solution2:
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int index = -1;
        List<Integer> result = new ArrayList<>();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1) index = left;

        int i = index - 1;
        int j = index;
        result.add(arr[index]);
        while (result.size() < k) {
            if (j > len || (i >= 0 && Math.abs(arr[i] - x) <= Math.abs(arr[j] - x))) {
                result.add(arr[i]);
                i--;
            } else {
                result.add(arr[j]);
                j++;
            }
        }
            Collections.sort(result);
            return result;
        }
}
