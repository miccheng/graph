package com.example.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEle {
    public static void main(String[] args) {
        int arr[] = {2, 4};
        int num[] = {1, 2, 3, 4};
        nextGreaterElement(arr, num);
    }
    //use map to record its greater number. Nearest-->stack
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }


}
