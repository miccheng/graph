package com.example.leetcode.datastructure;

import org.assertj.core.util.Lists;

import java.util.*;

public class MedianFinderDataStream {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(10, 20, 30, 40, 50);
        int d=3;
        TreeMap<Integer, Integer> map = new TreeMap<>();
    }

    Queue<Integer> lower=new PriorityQueue<>((a,b)->b-a);
    Queue<Integer> higher=new PriorityQueue<>();

    //***always make lower has more ele, and their size never>1
    public void addNum(int num) {
        lower.add(num);
        higher.add(lower.poll());
        if(lower.size()<higher.size()){
            lower.add(higher.poll());
        }
    }


    public double findMedian() {
        int size1=lower.size();
        int size2=higher.size();

        if(size1==size2){
            return (lower.peek()*1.0)/2+(higher.peek()*1.0)/2;
        }else{
            return lower.peek();
        }
    }

}
