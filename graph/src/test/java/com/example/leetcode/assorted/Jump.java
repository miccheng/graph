package com.example.leetcode.assorted;

import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Jump {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(2, 3, 603);
        List<Integer> list2 = Lists.newArrayList(1, 1, 286);
        List<Integer> list3 = Lists.newArrayList(4, 4, 882);
        List<List<Integer>> arrList = Lists.newArrayList(list1, list2, list3);
        arrayManipulation();

        int arr[]={4, 3, 1, 2};
        minimumSwaps(arr);
//        int arr[] = {0, 0, 0, 1, 0, 0};
//        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
//        jumpingOnClouds(collect);
    }
    public static long arrayManipulation() {
        int [] result=new int[]{1,2,3};
        long max=0;
        long sum=0;
        for(int j=0;j<result.length;j++){
//            sum+=result[j];
//            max=Math.max(sum, max);
            if(j-1>=0){
                result[j]=result[j]+result[j-1];
            }
              if(result[j]>max){
                     max=result[j];
                 }
        }
        return max;
    }


    static int minimumSwaps(int[] arr) {
        //key: value, value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            if (num != i + 1) {
                int index = map.get(i + 1);
                //swap
                arr[i] = arr[index];
                arr[index] = num;
                count++;
            }
        }
        return count;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        if (c.size() < 1 || c.get(0) == 1) return 0;

        List<Integer> indice = new ArrayList<>();
        for (int i = 0; i < c.size(); i++) {
            int num = c.get(i);
            if (num == 0) indice.add(i);
        }
        Collections.sort(indice);

        int start = 0;
        int count_step = 0;
        while (start < c.size() - 1) {//stops when it reaches end
            if (indice.contains(start + 2)) {
                start += 2;
            } else {
                start += 1;
            }
            count_step++;
        }
        return count_step;
    }
}
