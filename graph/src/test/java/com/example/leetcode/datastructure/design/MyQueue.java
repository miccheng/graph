package com.example.leetcode.datastructure.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    //use two stacks to implement queue
    //Key: Have to modify pop()&&peek to go in reverse order, we can use a 2nd stack for reversing. By popping
    // everything from s1 to s2, we can peek() from s2 to get the ele from the front and then push back to s1.
    //In this way, two stacks are performed back-to-back, we are needlessly moving elements.
    //Instead, we can do lazy. reverse ele only when we absolutely need to.

    Deque<Integer> newStack = new ArrayDeque<>();
    Deque<Integer> oldStack = new ArrayDeque<>();

    public void push(int x) {
        newStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        shiftEle();
        return newStack.pop();
    }


    // Get the front element.
    public int peek() {
        shiftEle();
        return newStack.peek();
    }

    // Return whether the queue is empty.
    public boolean isEmpty() {
        return size()==0;
    }

    public int size(){
        return newStack.size()+oldStack.size();
    }

    private void shiftEle() {
        if (oldStack.isEmpty()) {
            while (!oldStack.isEmpty()) {
                newStack.push(oldStack.pop());
            }
        }
    }
}
