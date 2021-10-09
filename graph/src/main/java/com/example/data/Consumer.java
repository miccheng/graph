package com.example.data;

public class Consumer<K,V> implements Runnable {
    private ConflatingQueue<K,V> queue;

    public Consumer(ConflatingQueue<K,V> queue) {
        this.queue = queue;
    }
    public void run()  {
        try {
            consume();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }


    private void consume() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            queue.take();
            System.out.println("consume"+ ":" +i);
        }

    }
}
