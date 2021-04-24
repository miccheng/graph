package com.example.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//    arr1 – arr2==complementary set
//    which means that we need to find all those elements which are present in arr1 but not in arr2.
public class RelativeComplementSet {
    public static void main(String[] args) {
        int [] arr1= {3, 5, 2, 7, 4, 2, 7};
        int [] arr2= {1, 7, 5, 2, 2, 9};
        relativeComplement(arr1,arr2);
    }

    public static List<Integer> relativeComplement(int [] arr1, int [] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++;
            } else {
                i++;
                j++;
            }
        }

        return result;
    }
}
