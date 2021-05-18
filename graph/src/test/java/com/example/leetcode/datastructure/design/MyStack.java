package com.example.leetcode.datastructure.design;

import java.util.LinkedList;
import java.util.Queue;

//use queue to implement stack functions
public class MyStack {
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


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        int param_2 = stack.pop();
        int param_3 = stack.top();
        boolean param_4 = stack.empty();

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        int size = queue.size();
//
//        while (size > 1) {
//            queue.add(queue.poll());
//            size--;
//        }
    }
}
