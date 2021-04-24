package com.example.leetcode.greedy.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int size = queue.size();

        while (size > 1) {
            queue.add(queue.poll());
            size--;
        }
    }

    Queue<Integer> queue = new LinkedList<>();
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i ++) { //****only reverse the head n-1 numbers and keep the last one where it is
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
