package com.example.leetcode.arraystr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastOccurNum {
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //0 ^ N = N
    //N ^ N = 0

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }


}
