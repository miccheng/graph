package com.example.leetcode.greedy;

public class PreviousPermutationOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        if(arr==null||arr.length==0) return arr;

        //identify pivot peek
        int len=arr.length;
        int peek=-1;
        for(int i=len-1;i>=1;i--){//spike point
            if(arr[i-1]>arr[i]){
                peek=i-1;
                break;
            }
        }

        if(peek==-1) return arr;
        //find the greatest smaller num< peek leftmost
        int swap=-1;
        int swapNum=Integer.MIN_VALUE;
        for(int j=peek+1;j<len;j++){
            if(arr[j]<arr[peek] && arr[j]>swapNum) {
                swap=j;
                swapNum=arr[j];
            }
        }
        //swap
        int tmp=arr[peek];
        arr[peek]=arr[swap];
        arr[swap]=tmp;

        return arr;
    }
}
