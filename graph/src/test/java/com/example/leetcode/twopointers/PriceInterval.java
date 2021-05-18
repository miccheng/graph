package com.example.leetcode.twopointers;

import java.util.*;

public class PriceInterval {
    public static void main(String[] args) {
        int arr[][]={{1,5,20},{3,6,15},{2,8,25}};
        Map<Integer, Integer> map = prepareMap(arr);
        sortPriceRange(map);
    }
    private static Map<Integer, Integer> prepareMap(int[][] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] ele : array) {
            int currentPrice = ele[2];
            for (int i = ele[0]; i <= ele[1]; i++) {
                if (map.containsKey(i)) {
                    if (map.get(i) > currentPrice)
                        map.put(i, currentPrice);//update
                } else {
                    map.put(i, ele[2]);
                }
            }
        }
        return map;
    }

    private static List<Interval> sortPriceRange(Map<Integer, Integer> map) {
        List<Interval> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result.isEmpty()) {
                result.add(new Interval(entry.getKey(), entry.getKey() + 1, entry.getValue()));
            } else {
                Interval lastInterval = result.get(result.size() - 1);
                if (lastInterval.getPrice() != entry.getValue()) {
                    lastInterval.endTime=entry.getKey()-1;
                    result.add(new Interval(entry.getKey(),entry.getKey()+1,entry.getValue()));
                } else {//extend time
                    lastInterval.endTime = entry.getKey() + 1;
                }
            }
        }
        return result;
    }

//    private static Map<Interval, Integer> getPriceRange(int[][] array) {
//        Arrays.sort(array,(a,b)->a[0]-b[0]);
//        Map<Interval, Integer> map = new LinkedHashMap<Interval, Integer>();
//        map.put(new Interval(array[0][0], array[0][1]),array[0][2]);
//
//        int[] current = array[0];
//        for (int i = 1; i < array.length; i++) {
//            int[] interval = array[i];
//            for (Map.Entry<Interval, Integer> entry : map.entrySet()) {
//                Interval current_time = entry.getKey();
//                Integer price = entry.getValue();
//                if (interval[0] < current_time.getEndTime())//overlap
//                    if (interval[2] < price) //coming next is cheaper
//                        current_time.endTime = interval[0];//shrink previous window
//                    else
//                        interval[0] = current_time.getEndTime();//don't do anything on current but shrink now window
//                else
//                    map.put(new Interval(interval[0], interval[1]), interval[2]);
//            }
//        }
//
//        return map;
//    }

    static class Interval{
        int startTime;
        int endTime;
        int price;

        public Interval(int startTime, int endTime, int price) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        public int getPrice() {
           return price;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
