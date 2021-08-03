package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        if(arr==null|| arr.length==0) return 0;
        int len=arr.length;
        long result[]=new long[len];
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            int top=stack.isEmpty()?-1:stack.peek();
            result[i]=top==-1?(i+1)*arr[i]:result[top]+(i-top)*arr[i];
            stack.push(i);
        }

        long sum=0;
        long mod=(int)1e9 + 7;
        for(long res: result){
            sum+=res;
        }

        return (int)(sum%mod);
    }
}
