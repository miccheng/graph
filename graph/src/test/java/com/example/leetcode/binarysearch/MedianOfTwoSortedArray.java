package com.example.leetcode.binarysearch;

import java.util.HashMap;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int nums1[] = {2};
        int nums2[] = {1, 3};
        findMedianSortedArrays(nums1, nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = map.entrySet().stream().filter(e -> e.getValue() > 2).count();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);//let nums1 always be the smaller array

        int total = len1 + len2;
        int half = total / 2;

        int left = 0;
        int right = nums1.length - 1;
        while (true) {
            //*** careful with negative integer. Manual floor of negative int is required
            double floor = Math.floor((right - left) / 2.0);
            int mid = left + (int) floor;
            int Aleft = mid < 0 ? Integer.MIN_VALUE : nums1[mid];
            int Aright = mid + 1 >= len1 ? Integer.MAX_VALUE : nums1[mid + 1];

            int j = half - mid - 2;
            int Bleft = j < 0 ? Integer.MIN_VALUE : nums2[j];
            int Bright = j + 1 >= len2 ? Integer.MAX_VALUE : nums2[j + 1];

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else {
                    return Math.min(Aright, Bright);
                }
            } else if (Aleft > Bright) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

    }
}
