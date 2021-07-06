package com.example.leetcode.datastructure;

import org.assertj.core.util.Lists;

import java.util.*;

//Can't use treemap here. Wrong answer
public class FraudNotifications {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(10, 20, 30, 40, 50);
        activityNotifications(integers,3);
    }

    private static TreeSet<Integer> small=new TreeSet<>(Collections.reverseOrder());//***
    private static TreeSet<Integer> big=new TreeSet<>();

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int len = expenditure.size();
        int counter = 0;

        for (int i = 0; i < d; i++) {
            int num = expenditure.get(i);
            add(expenditure,i);
        }

        for (int i = d; i < len; i++) {
            int medianTwice=getMedian(expenditure,d);
            int current=expenditure.get(i);
            if(medianTwice<=current){
                counter++;
            }
            remove(expenditure,i-d);
            add(expenditure,i);
        }
        return counter;

    }


    public static int getMedian(List<Integer> expenditure,int d){
        if(d%2==0){
            return (expenditure.get(small.first())+expenditure.get(big.first()))*2;
        }
        return expenditure.get(small.first())*2;
    }

    public static void remove(List<Integer> expenditure,int i){
        int num=expenditure.get(i);
        if(small.remove(num)) return;
        if(big.remove(num)) return;
    }

    public static void add(List<Integer> expenditure,int i){
        small.add(i);
        big.add(small.pollFirst());
        if(small.size()<big.size()){
            small.add(big.pollFirst());
        }
    }

}
