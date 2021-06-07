package com.example.leetcode.datastructure.design;

public class ArrayQueue<T> {
    private int front, rear;
    private Object [] data;

    public ArrayQueue(int capacity){
        data=new Object[capacity+1];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear == data.length - 1;
    }

    public void offer(T obj) {
        if (isFull()) return;
        if (isEmpty())//move both when only have 1 ele
            front = rear = 0;
        else
            rear = rear + 1;
        data[rear] = obj;
    }

    public T poll() {
        if (isEmpty()) return null;
        T ele = (T) data[front];
        if (rear == front) {//only 1 ele in it, after polling its empty, so set both to -1
            rear = -1;
            front = -1;
        } else {
            front++;
        }
        return ele;
    }

    public T peek() {
        if (front == -1) return null;
        return (T) data[front];
    }


}
