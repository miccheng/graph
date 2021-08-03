package com.example.leetcode.arraystr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {
    // return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
    //merge the intersection to get a narrower interval to avoid more overlapping removed needed in future
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null) return 0;
        int len=intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
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
