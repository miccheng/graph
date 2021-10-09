package com.example.data;

public class Producer <K,V> implements Runnable{
    private ConflatingQueue<K,V> queue;

    public Producer(ConflatingQueue<K,V> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            produce();
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void produce() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            queue.offer(new Pair<K, V>("BTCUSD","hello"));
            System.out.println("produce"+ ":" +i);
        }
    }
}
