package com.example.leetcode.binarysearch.range;

import java.util.PriorityQueue;

//Kth problem usually can be solved by heap
public class Find2ndLargest {
    //solution 1: use heap
    private static int findKthNumber(int[] arr) {
//        PriorityQueue<Integer> prq = new PriorityQueue<>((a,b)->b-a); max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();//min heap
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > 2) heap.remove();
        }
        return heap.remove();
    }

    //solution 2: keep track of 2 variables
    private static int find2ndNumber(int[] arr) {
        int largestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestNum) {
                largestNum = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largestNum && arr[i] > secondLargestNum) {
                secondLargestNum = arr[i];
            }
        }
        return secondLargestNum;
    }

    //solution 3: keep track of 2 variables
    private static int find2ndNumberUpgrade(int[] arr) {
        int largestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestNum) {
                secondLargestNum = largestNum;
                largestNum = arr[i];
            } else if (arr[i] > secondLargestNum) {
                secondLargestNum = arr[i];
            }
        }

        return secondLargestNum;
    }

    //solution 4: partitioning
}
