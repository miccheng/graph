package com.example.leetcode.twopointers.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null) return 0;
        int len=intervals.length;
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        List<int []> result=new ArrayList<>();
        int [] previous=intervals[0];
        result.add(previous);

        for(int i=1;i<len;i++){
            if(intervals[i][0]<previous[1]){
                previous[0]=intervals[i][0];
                previous[1]=Math.min(intervals[i][1],previous[1]);
            }else{
                result.add(intervals[i]);
                previous=intervals[i];
            }
        }

        return len-result.size();
    }
}
