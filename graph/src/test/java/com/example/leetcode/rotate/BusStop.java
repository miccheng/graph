package com.example.leetcode.rotate;

public class BusStop {

    public static void main(String args[]){
       int arr[]= {1,2,3,4};
       distanceBetweenBusStops(arr,0,3);
    }
    public static int distanceBetweenBusStops(int[] array, int start, int destination) {
        int distance1 = 0;
        int distance2 = 0;
        //swap
        if (start > destination) {
//            int temp = start;
//            start = destination;
//            destination = temp;
            start = start + destination;
            destination = start - destination;
            start = start - destination;
        }

        for (int i = start; i < destination; i++) {
            distance1 += array[i];
        }

        int j=destination;
        while (j >= destination || j < start) {//***condition
            if (j < array.length) {
                distance2 += array[j];
                j++;
            } else {
                j = j - array.length;
            }
        }


        return Math.min(distance1, distance2);
    }
}
