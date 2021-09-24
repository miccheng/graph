package com.example.leetcode.twopointers.intervals;

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
            int len=intervals.length;
            List<int[]>result=new ArrayList<>();
            if(intervals==null) return result.toArray(new int [0][0]);
            if(len==1)return intervals;

            Arrays.sort(intervals,(a,b)->a[0]-b[0]);

            int [] previous=intervals[0];
            result.add(previous);

            for(int i=1;i<len;i++){
                if(i<len&&intervals[i][0]<=previous[1]){
                    int [] current=intervals[i];
                    // won't work!!!  previous=new int[]{min,max};
                    int max=Math.max(current[1],previous[1]);
                    previous[1]=max;
                }else{
                    result.add(intervals[i]);
                    previous=intervals[i];
                }
            }

            return result.toArray(new int [0][0]);
        }
}


