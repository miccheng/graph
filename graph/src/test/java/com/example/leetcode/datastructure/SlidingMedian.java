package com.example.leetcode.datastructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingMedian {
    public static void main(String[] args) {
//       int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;


        int[] nums={1,4,2,3};
        int k=4;
//        medianSlidingWindow(nums,k);
    }

    private Queue<Integer> higher= new PriorityQueue<>();
    private Queue<Integer> lower=new PriorityQueue<>((a,b)->b.compareTo(a));

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        double[] medians=new double[len-k+1];

        //get first median
        int i=0;
        for(;i<k;i++){
            addNum(nums[i]);
            rebalance(k);
        }
        medians[0]=caculateMedian(k);


        for(;i<len;i++){
            remove(nums[i-k]);
            addNum(nums[i]);
            rebalance(k);
            double median=caculateMedian(k);
            medians[i-k+1]=median;
        }

        return medians;
    }


    private void remove(int n){
        if(lower.contains(n)){
            lower.remove(n);
        } else{
            higher.remove(n);
        }
    }

    private void addNum(int n){
        if(lower.isEmpty()&&higher.isEmpty()){
            lower.add(n);
        }else if(!lower.isEmpty() && n<lower.peek()){
            lower.add(n);
        }else {
            higher.add(n);
        }
    }

    private void rebalance(int k){
        Queue<Integer> bigger= higher.size()>lower.size()? higher:lower;
        Queue<Integer> smaller= higher.size()>lower.size()? lower:higher;

        while(bigger.size()-smaller.size()>k%2){
            smaller.add(bigger.poll());
        }
    }

    private double caculateMedian(int k){
        Queue<Integer> bigger= higher.size()>lower.size()? higher:lower;
        Queue<Integer> smaller= higher.size()>lower.size()? lower:higher;
        if(k%2==0){
            return (bigger.peek()*1.0/2+smaller.peek()*1.0/2);
        }else{
            return bigger.peek();
        }

    }

}
