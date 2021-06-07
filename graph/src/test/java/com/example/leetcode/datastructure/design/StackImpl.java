package com.example.leetcode.datastructure.design;

import java.util.EmptyStackException;

//Stack implemented using linkedlist
//operation are append/remove on head of linked list
public class StackImpl<T> {
    public StackNode<T> top;

    public void push(T item) {//append in front of head
        StackNode<T> node = new StackNode<>(item);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;

        public StackNode(T data) {
            this.data = data;
        }
    }

}
