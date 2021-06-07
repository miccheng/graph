package com.example.leetcode.datastructure.design;

import java.util.ArrayDeque;
import java.util.Deque;

// Example:
// push(5): stack is {5}, min is 5
// push(6); stack is {6,5}, min is 6
// push(3): stack is {3,6,5}, min is 3
// push(7): stack is {7,3,6,5}, min is 3
// pop(7): stack is {3,6,5}, min is 3
// pop(3): stack is {6,5}, min is 5
// Constraints: operation all are O(1) time
public class MinStack {

    //Solution 1: by keeping track of the previous ele pushed
    //***problem: when the stack gets really large, we are keeping track of the min for every single ele
    private Node head;
    public void pushh(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    public void popp() {
        head = head.next;
    }
    public int topp() {
        return head.val;
    }
    public int getMinn() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;
        private Node(int val, int min) {
            this(val, min, null);
        }
        private Node(int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }


    //Solution 2: use 2 stack with O(1) time && O(n) space
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min_stack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        if (stack.peek().equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
