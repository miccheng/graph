package com.example.leetcode.twopointers.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    //After merge, the new interval can be spanning before , overlapping, and behind the coming interval
    //None overlapping: Before [3,6] to insert [1,4]-->[1,6]. Coming up [8,10]
    //None overlapping: Behind[10,12]. coming up [17,18]
    //Overlapping:what is left must be overlapping: [3,5], to insert [4,8]-->[3,8]. The coming is [6,7]
    public int[][] insertt(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;

        for (int i = 0; i < intervals.length; i ++) {
            //before current
            // [3,6] [1,2]
            if (intervals[i][0] > toAdd[1]) {
                ans.add(toAdd);
                toAdd = intervals[i];
            }
            //behind current
            else if (toAdd[0]>intervals[i][1])
                ans.add(intervals[i]);
            //overlap
            else // (intervals[i][1] >= toAdd[0])
                toAdd = new int[] {Math.min(intervals[i][0], toAdd[0]), Math.max(intervals[i][1], toAdd[1]) };
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }



    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }

        List<int[]> res = new ArrayList<>();
        //identify
        int start = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interv = intervals[i];
            if (newInterval[0] <= interv[1]) {
                start = i;
                break;
            }
            res.add(interv);
        }

        //merge

        //[6,9] newInterval[3,5]
        while (start < intervals.length && newInterval[0] <= intervals[start][1] && newInterval[1] >= intervals[start][0]) {
            int min = Math.min(intervals[start][0], newInterval[0]);
            int max = Math.max(intervals[start][1], newInterval[1]);
            newInterval = new int[]{min, max};
            start++;
        }
        //[6,7] newInterval [3,8]
        while (start < intervals.length && newInterval[0] >= intervals[start][0] && newInterval[1] >= intervals[start][1]) {
            // res.add(newInterval);
            start++;
        }

        res.add(newInterval);
        for (int i = start; i < intervals.length; i++) {
            res.add(intervals[i]);
        }
        return res.toArray(new int[0][0]);
    }


}
