package com.example.data;

import java.util.HashMap;
import java.util.Map;

public class ConflatingQueueImpl<K,V> implements ConflatingQueue<K,V>{
    Map<K,Node<KeyValue>> map;
    MyQueue<Node<KeyValue>> queue;

    public ConflatingQueueImpl() {
        this.map = new HashMap<>();
        this.queue = new MyQueue<>();
    }

    @Override
    public boolean offer(KeyValue e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        K key = (K) e.getKey();
        if (map.containsKey(key)) return update(e);

        Node<KeyValue> node = new Node<>(e);
        queue.offer(node);
        map.put(key, node);
        return true;
    }

    private boolean update(KeyValue keyValue) {
        K key = (K)keyValue.getKey();
        if (!map.containsKey(key)) return false;
        queue.fullyLock();
        try {
            Node<KeyValue> node = map.get(key);
            node=new Node(keyValue);
            return false;
        } finally {
            queue.fullyUnlock();
            return true;
        }
    }

    @Override
    public KeyValue take() throws InterruptedException {
        KeyValue toRemove = queue.take();
        map.remove(toRemove);
        return  toRemove;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }



}
