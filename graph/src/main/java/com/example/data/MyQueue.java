package com.example.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<K,V> implements ConflatingQueue<K, V> {
    private final ReentrantLock lock = new ReentrantLock();
    private final AtomicInteger count = new AtomicInteger();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final int capacity;

    transient Node<KeyValue> head;
    private transient Node<KeyValue> last;
    private Map<K,Node<KeyValue>> map;


    public MyQueue() {
        this.capacity = Integer.MAX_VALUE;
        last = head = new Node<KeyValue>(null);
        map=new HashMap<>();
    }


    @Override
    public boolean offer(KeyValue<K, V> keyValue) throws InterruptedException {
        checkNotNull(keyValue);
        Node node=new Node(keyValue);
        // Note: convention in all put/take/etc is to preset local var
        // holding count negative to indicate failure unless set.
        int c = -1;
        final ReentrantLock putLock = this.lock;
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
            K key=keyValue.getKey();
            if(map.containsKey(key)){//update
                Node<KeyValue> original = map.get(key);
                original.item=keyValue;
            }else{//write
                enqueue(node);
                map.put(key,node);
                c = count.getAndIncrement();
            }

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
        final ReentrantLock takeLock = this.lock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            x = dequeue();
            map.remove((K)x.getKey());
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

    private void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.lock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock putLock = this.lock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

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


}
