package com.example.leetcode.twopointers.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomII {
    public static void main(String[] args) {
       int arr[][]={{2,15},{36,45},{9,29},{16,23}, {4,9}};
//       int arr[][]={{7,10},{2,4}};
        minMeetingRooms(arr);
    }

//  always put the earliest ending meeting at the top
    //heap stores the conflicting meetings
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> heap=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        heap.add(intervals[0]);

        //!!!must pop when the boundary is adjusted. so heap can heapfy to reorder ele
        for(int i=1;i<len;i++) {
            if (intervals[i][0] < heap.peek()[1]) {//don't overlap, need extra room
                heap.add(intervals[i]);
            } else {
                int[] ele = heap.poll();
                ele[1] = intervals[i][1];//extend the previous room
                heap.add(ele);
            }
        }
        return heap.size();
    }


    public boolean canAttendMeetings(int [][] intervals) {
        Arrays.sort(intervals);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
