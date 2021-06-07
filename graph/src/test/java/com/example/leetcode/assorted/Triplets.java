package com.example.leetcode.assorted;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//bottle neck: have to record frequency and its order(index) at the same time
// a(i), a*r(j), ar^2(k). have to check j comes before k.
// a/r, a, a*r. go left to check whether i exist and k exist in right map.
public class Triplets {
    public static void main(String[] args) {
        long arr[]={1,2,2,4};
        List<Long> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        countTriplet(list,2);
    }

    static long countTriplet(List<Long> arr, long r) {
        Map<Long, Integer> rightMap = new HashMap<>();
        Map<Long, Integer> leftMap = new HashMap<>();
        for (Long num : arr) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        long result = 0;
        for (int i = 0; i < arr.size(); i++) {
            long mid = arr.get(i);
            int biggerFre = rightMap.getOrDefault(mid * r, 0);
            int smallerFre = leftMap.getOrDefault(mid / r, 0);
            result += biggerFre * smallerFre;

            //    int updateBig=biggerFre==0?0:biggerFre-1;
            rightMap.put(mid, rightMap.get(mid) - 1);
            leftMap.put(mid, leftMap.getOrDefault(mid, 0) + 1);
        }

        return result;
    }
    //as the window moves, the left and right map gets updated
    public static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();
        //frequency
        for (long item : arr) {
            rightMap.put(item, rightMap.getOrDefault(item, 0L) + 1);
        }

        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);

            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);//***exclude the current num
            long c1 = leftMap.containsKey(midTerm / r) && midTerm % r == 0 ? leftMap.get(midTerm / r) : 0;
            //long truncate problem

            long c3 = rightMap.getOrDefault(midTerm * r, 0L);
            count += c1 * c3;

            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }
        return count;
    }


}
