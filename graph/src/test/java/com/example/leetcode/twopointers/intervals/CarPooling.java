package com.example.leetcode.twopointers.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    //can't add 1st array at the beginning as the 1st might be >capacity already[9,1,2], capacity=4;
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < trips.length; i++) {
            int[] cur = trips[i];
            while (!heap.isEmpty() && cur[1] >= heap.peek()[2]) {//!overlap
                capacity += heap.poll()[0];
            }
            capacity -= cur[0];
            if (capacity < 0) return false;
            heap.add(cur);

        }
        return true;
    }
}
