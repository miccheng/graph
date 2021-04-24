package com.example.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
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


    //solution 2: use 2 stack
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min_stack = new ArrayDeque<>();

    public void push(int val) {
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
        stack.push(val);

    }

    public void pop() {
        if (stack.peek().equals(min_stack.peek())) {
            min_stack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
