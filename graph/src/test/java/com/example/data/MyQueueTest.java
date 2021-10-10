package com.example.data;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MyQueueTest {
    @Test
    public void shouldBeEmpty() {
        MyQueue myQueue = new MyQueue();

        Assert.assertEquals("Should be empty", true, myQueue.isEmpty());
    }

    @Test
    public void canOfferNewItem() {
        MyQueue myQueue = new MyQueue();

        Pair item = new Pair("BTCUSD", "7000");
        try {
            myQueue.offer(item);
        } catch (InterruptedException e) {
            Assert.fail();
        }

        Assert.assertEquals("Should not be empty", false, myQueue.isEmpty());
    }

    @Test
    public void canTakeItem() {
        MyQueue myQueue = new MyQueue();

        Pair item = new Pair("BTCUSD", "7000");
        try {
            myQueue.offer(item);
            KeyValue kv = myQueue.take();

            Assert.assertEquals("Should now be empty", true, myQueue.isEmpty());
            Assert.assertEquals("Taken item should have correct value", "7000", kv.getValue());
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    @Test
    public void canDoInSequence() {
        MyQueue myQueue = new MyQueue();

        try {
            Pair item1 = new Pair("BTCUSD", "7000");
            myQueue.offer(item1);

            Pair item2 = new Pair("ETHUSD", "250");
            myQueue.offer(item2);

            Pair item3 = new Pair("BTCUSD", "7002");
            myQueue.offer(item3);

            KeyValue event1 = myQueue.take();
            KeyValue event2 = myQueue.take();

            Assert.assertEquals("Should be BTCUSD", "BTCUSD", event1.getKey());
            Assert.assertEquals("Should be new value 7002", "7002", event1.getValue());
            Assert.assertEquals("Should be ETHUSD", "ETHUSD", event2.getKey());
            Assert.assertEquals("Should be unchanged 250", "250", event2.getValue());

            Assert.assertEquals("Should now be empty", true, myQueue.isEmpty());
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    @Test
    @Ignore("Not testing as this causes blocking")
    public void shouldBlockWhenQueueIsEmpty() {
        MyQueue myQueue = new MyQueue();

        try {
            myQueue.take();
            Assert.fail("Expected an InterruptedException to be thrown");
        } catch (InterruptedException e) {

        }
    }
}
