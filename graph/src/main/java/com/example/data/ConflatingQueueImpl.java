package com.example.data;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConflatingQueueImpl implements ConflatingQueue{
    private final ReentrantLock putLock = new ReentrantLock();
    private final AtomicInteger count = new AtomicInteger();

    private final Condition notFull = putLock.newCondition();
    private final int capacity;

    transient Node<KeyValue> head;
    private transient Node<KeyValue> last;


    private final ReentrantLock takeLock = new ReentrantLock();
    private final Condition notEmpty = takeLock.newCondition();

    public ConflatingQueueImpl() {
        this.capacity = Integer.MAX_VALUE;
        last = head = new Node<KeyValue>(null);
    }


    @Override
    public boolean offer(KeyValue e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        // Note: convention in all put/take/etc is to preset local var
        // holding count negative to indicate failure unless set.
        int c = -1;
        Node<KeyValue> node = new Node<>(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try {
            /*
             * Note that count is used in wait guard even though it is
             * not protected by lock. This works because count can
             * only decrease at this point (all other puts are shut
             * out by lock), and we (or some other waiting put) are
             * signalled if it ever changes from capacity. Similarly
             * for all other uses of count in other wait guards.
             */
            while (count.get() == capacity) {
                notFull.await();
            }
            enqueue(node);
            c = count.getAndIncrement();
            if (c + 1 < capacity)
                notFull.signal();
        } finally {
            putLock.unlock();
        }
        if (c == 0)
            signalNotEmpty();
        return true;
    }

    @Override
    public KeyValue take() throws InterruptedException {
        KeyValue x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        if (c == capacity)
            signalNotFull();
        return x;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }




    public int size() {
        return count.get();
    }

    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    //TODO: need to override the value if found pair
    private void enqueue(Node<KeyValue> node) {
        last = last.next = node;
    }


    private KeyValue dequeue() {
        // assert takeLock.isHeldByCurrentThread();
        // assert head.item == null;
        Node<KeyValue> h = head;
        Node<KeyValue> first = h.next;
        h.next = h; // help GC
        head = first;
        KeyValue x = first.item;
        first.item = null;
        return x;
    }


    class Node<KeyValue> {
        KeyValue item;

        Node<KeyValue> next;

        Node(KeyValue x) { item = x; }
    }
}
