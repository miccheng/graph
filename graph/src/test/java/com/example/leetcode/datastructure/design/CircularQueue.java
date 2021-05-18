package com.example.leetcode.datastructure.design;

import java.util.NoSuchElementException;

//****double ended queue can be implemented either using circular array or linkedlist
public class CircularQueue {
    //insertion at front, deletion from rear
    private int front, rear;
    private int[] nums;

    public CircularQueue(int initSize) {
        this.front = this.rear = -1;
        this.nums = new int[initSize];
    }

    public void enqueue(int data) {
        if (isFull())
            resize();
        else if (isEmpty())
            front++;
        rear = (rear + 1) % nums.length;
        nums[rear] = data;
    }


    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        int temp = nums[front];
        //only one ele in the array, set pointers back
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % nums.length;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return nums[front];
    }

    private void resize() {
        int[] tempArr = new int[nums.length * 2];
        int i = 0;//traverse new array
        int j = front;//traverse old array
        do {
            tempArr[i++] = nums[j];
            j = (j + 1) % nums.length;
        } while (j != front);

        front = 0;
        rear = nums.length - 1;
        nums = tempArr;
    }

    private boolean isEmpty() {
        return front==-1;
    }

    private boolean isFull() {
        return (rear + 1) % nums.length == front;
    }
}
