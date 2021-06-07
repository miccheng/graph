package com.example.leetcode.datastructure.design;

import java.util.Arrays;
import java.util.EmptyStackException;

//***Implementation of stack using array
//operation are on append/remove to the back of array
public class ArrayStack<T> {
    private int capacity;
    private Object[] data;
    private int top=-1;

    public ArrayStack () {
        capacity = 1 << 4;
        data = new Object[capacity];
    }

    public int size() {
        return top == -1 ? 0 : top + 1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(T ele) {
        //check if need resize
        if (top + 1 == capacity) {
            resize();
        }
        top++;
        data[top] = ele;
    }

    private void resize() {
        Object[] array = new Object[capacity * 2];
        array = Arrays.copyOf(data, capacity);
    }

    public T pop() {
        if (top == -1) throw new EmptyStackException();
        T ele = (T) data[top];
        data[top] = null;
        top--;
        return ele;
    }

    public T peek() {
        if (top == -1) throw new EmptyStackException();
        T ele = (T) data[top];
        return ele;
    }

}
