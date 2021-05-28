package com.example.leetcode.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        //two heaps
        PriorityQueue<Integer> lesser = new PriorityQueue<>((e, b) -> b - e);
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        List<Double> medians = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            //add nunmber
            addNumber(lesser, greater, num);
            //rebalance
            rebalance(lesser, greater);
            //calMedian
            double median = calMedian(lesser, greater);
            medians.add(median);
        }
        return medians;
    }


    public static void addNumber(PriorityQueue<Integer> lesser, PriorityQueue<Integer> greater, int num) {
        if (lesser.isEmpty() || num < lesser.peek()) {
            lesser.add(num);
        } else {
            greater.add(num);
        }

    }

    public static void rebalance(PriorityQueue<Integer> lesser, PriorityQueue<Integer> greater) {
        PriorityQueue<Integer> bigger = lesser.size() > greater.size() ? lesser : greater;
        PriorityQueue<Integer> smaller = lesser.size() > greater.size() ? greater : lesser;

        while (Math.abs(bigger.size() - smaller.size()) >= 2) {
            smaller.add(bigger.poll());
        }
    }

    public static double calMedian(PriorityQueue<Integer> lesser, PriorityQueue<Integer> greater) {
        PriorityQueue<Integer> bigger = lesser.size() > greater.size() ? lesser : greater;
        PriorityQueue<Integer> smaller = lesser.size() > greater.size() ? greater : lesser;

        if (smaller.size() == bigger.size()) {
            return ((double) bigger.peek() + smaller.peek()) / 2;
        } else {
            return bigger.peek();
        }
    }
}
