package com.example.leetcode.arraystr;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CountSort {

    public void countingSort(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        //1. iterate array, find out min && max
       //2. count frequency of num in arr
        int[] count = new int[5];//new int[max]
        Arrays.fill(count,0);
        for (int num:arr) {
            count[num]++;
        }
        //3. sum count
        for (int i = 1; i < arr.length; i++) {
            count[i]=count[i]+count[i-1];
        }
        //4.sort in b array
        int[] b = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            b[--count[arr[i]]] = arr[i];
        }
        //final: copy b to a
        for (int i = 0; i < arr.length; i++) {
            b[i]=arr[i];
        }
    }
}
