package com.example.leetcode.twopointers;

import java.util.Arrays;

//Shortest Unsorted Continuous Subarray
public class DistributeCandy {
//    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//    You are giving candies to these children subjected to the following requirements:
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.

    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size <= 1)
            return size;

        int[] num=new int[size];
        Arrays.fill(num,1);
        //left neighbour
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
        }
        //right neighbour
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                num[i - 1] = Math.max(num[i] + 1, num[i - 1]);
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += num[i];
        }
        return result;
    }
}
