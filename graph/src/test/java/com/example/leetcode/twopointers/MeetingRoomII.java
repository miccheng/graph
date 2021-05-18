package com.example.leetcode.twopointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static void main(String[] args) {
       int arr[][]={{0,30},{5,10},{15,20}};
//       int arr[][]={{7,10},{2,4}};
        minMeetingRoom(arr);
    }

//  check the earliest end meeting room can be reused or not
    public static int minMeetingRoom(int [][] intervals){
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        heap.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] earliest = heap.remove();
            if (current[0] <= earliest[1]) //can't be reused
                heap.add(current);
            else
                earliest[1] = Math.max(current[1], earliest[1]);

            heap.add(earliest);//***add it back
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
