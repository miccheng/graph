package com.example.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConflatingQueueImpl<K,V> implements ConflatingQueue<K,V>{
    Map<K,Node<KeyValue>> map;
    LinkedBlockingQueue<Node<KeyValue>> queue;

    final ReentrantLock lock;

    public ConflatingQueueImpl() {
        this.lock = new ReentrantLock();
        this.map = new HashMap<>();
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public boolean offer(KeyValue e) throws InterruptedException {
        checkNotNull(e);
        K key = (K) e.getKey();
        if (map.containsKey(key)) return update(e);
        return write(e);
    }


    private boolean write(KeyValue keyValue) throws InterruptedException {
        K key = (K)keyValue.getKey();
        Node<KeyValue> node = new Node<>(keyValue);
        lock.lockInterruptibly();
        try{
            queue.offer(node);
            map.put(key, node);
        }finally {
            lock.unlock();
            return true;
        }
    }

    private boolean update(KeyValue keyValue) throws InterruptedException {
        K key = (K)keyValue.getKey();
        if (!map.containsKey(key)) return false;

        lock.lockInterruptibly();
        try {
            Node<KeyValue> node = map.get(key);
            node.item=keyValue;
        } finally {
            lock.unlock();
            return true;
        }
    }

    @Override
    public KeyValue take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            KeyValue toRemove = (KeyValue) queue.take();
            map.remove(toRemove);
            return toRemove;
        } finally {
            lock.unlock();
        }
    }


    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    private void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

}
