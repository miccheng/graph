package com.example.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        int row = intervals.length;
        //sort array
        Arrays.sort(intervals, (e1, e2) -> Integer.compare(e1[0], e2[0]));

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] current = intervals[0];

        for (int[] interv : intervals) {
            if (interv[0] <= current[1]) {
                current[1] = Math.max(current[1], interv[1]);
            } else {
                current = interv;
                list.add(interv);
            }
        }

        return list.toArray(new int[0][0]);
    }
}
