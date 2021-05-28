package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterEleII {
    //***wrap around index by *2, and store index in stack
    //similar to check a string is a rotated of another string,"tackoverflows", "ackoverflowst"
    //circular array
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
