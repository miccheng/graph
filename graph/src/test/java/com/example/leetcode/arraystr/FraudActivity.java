package com.example.leetcode.arraystr;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FraudActivity {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(10,20,30,40,50);
        activityNotifications(list, 4);
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int len = expenditure.size();
        int counter = 0;
        double median = -1.0;
        int[] count = new int[201];
        for (int i = 0; i < d; i++) {
            int num = expenditure.get(i);
            count[num]++;
        }
        for (int i = d; i < expenditure.size(); i++) {
            median = getMedian(count, d);
            //compare
            int next = expenditure.get(i);
            if (median <= next) {
                counter++;
            }
            updateFrequency(expenditure.get(i - d), expenditure.get(i), count);
        }
        return counter;

    }

    public static void updateFrequency(int old,int next, int [] count){
        count[old]--;
        count[next]++;
    }

    public static double getMedian(int []count, int d) {
        double median = 0;
        int i = 1;
        int first = (int) Math.floor((d + 1)*1.0 / 2);
        int second = (int) Math.ceil((d + 1)*1.0 / 2);
        int k = 0;
        int total = 0;

        while (i < count.length && k < first) {
            k += count[i];
            i++;
        }
        total += i - 1;

        while (i < count.length && k < second) {
            k += count[i];
            i++;
        }
        total += i - 1;
        median = total * 1.0;
        return median;
    }

//    public static double getMedian(int []count, int d){
//        double median = 0;
//        int i = 1;
//        if (d % 2 == 0) {
//            int first = d / 2;
//            int second = first + 1;
//            int k=0;
//            int total = 0;
//
//            while (i < count.length && k < first) {
//                k+=count[i];
//                i++;
//            }
//            total += i-1;
//
//            while (i < count.length && k < second) {
//                k+=count[i];
//                i++;
//            }
//            total += i-1;
//            median = total * 1.0 ;
//        } else {
//            int mid = d / 2 + 1;
//            int k=0;
//            while (i < count.length && k < mid) {
//                k+=count[i];
//                i++;
//            }
//            median = (i-1)*2;
//        }
//        return median;
//
//    }


}