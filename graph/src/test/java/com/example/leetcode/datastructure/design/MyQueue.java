package com.example.leetcode.datastructure.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    //use two stacks
    Deque<Integer> pushStack = new ArrayDeque<>();
    Deque<Integer> popStack = new ArrayDeque<>();

    public void push(int x) {
        while (!popStack.isEmpty()) {//check the counterparty stack instead of itself
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
       return popStack.pop();
    }


    // Get the front element.
    public int peek() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

}
