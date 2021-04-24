package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortArrayUsingStack {
    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 3, 8};
        int n = arr.length;
        sortArrayUsingStacks(arr, n);
    }

    public static void sortArrayUsingStacks(int arr[], int n) {
        Deque<Integer> inputStack = new ArrayDeque<>();
        for (int num : arr) {
            inputStack.push(num);
        }

        //inputStack 2: 1,3,4,6,8
        Deque<Integer> resultStack = new ArrayDeque<>();
        while (!inputStack.isEmpty()) {
            Integer ele = inputStack.peek();
            inputStack.pop();
            while (!resultStack.isEmpty() && ele > resultStack.peek()) {
                Integer temp = resultStack.peek();
                resultStack.pop();
                inputStack.push(temp);
            }
            // next < resultStack.pop()
            resultStack.push(ele);
        }
        System.out.println(resultStack);
    }
}