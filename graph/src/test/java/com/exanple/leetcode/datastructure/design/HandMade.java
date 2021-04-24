package com.exanple.leetcode.datastructure.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HandMade<K,V> implements Iterable<K> {

    private static int default_capacity = 1 << 4;
    private static final float load_factor = 0.75f;
    private Entry<K, V> entry;
    private int capacity,thredshold = 0;
    private LinkedList<Entry<K, V>>[] table;

    //constructorhah
    public HandMade() {
        this(default_capacity);
    }

    public HandMade(int size) {
        if (size < 0) throw new IllegalArgumentException("capacity can't be less than 0");
        this.capacity = Math.max(default_capacity, size);
        thredshold = (int) (capacity * load_factor);
        table = new LinkedList[capacity];
    }


    //int getSize()
    public int getSize() {
        return capacity;
    }

    //boolean isEmpty()
    public boolean isEmpty() {
        return capacity == 0;
    }


    //void clear();
    public void clear() {
        Arrays.fill(table,null);
        capacity =0;
    }


    //void put(K key, V value), return old value
    public V put(K key, V value) {
        if(key==null) throw new IllegalArgumentException("key can't be nulls");

        Entry<K, V> entry = new Entry<>(key, value);
        //get index
        int bucketIndex = getBucketIndex(key);

        //check linkedlist if it's null
        LinkedList<Entry<K,V>> bucket=table[bucketIndex];
        if (bucket == null) table[bucketIndex] = bucket = new LinkedList<>();

        //check existence, and search for slot
        Entry<K, V> existence = checkExistence(bucketIndex, key);
        //put or update value
        if (existence == null) {
            bucket.add(entry);
            capacity++;
            //******see if resize is needed
            if (capacity > thredshold) resize();
            return null;
        } else {
            V old_value=existence.value;
            existence.value = value;
            return old_value;
        }
    }


    private Entry<K, V> checkExistence(int bucketIndex, K key) {
        LinkedList<Entry<K, V>> list = table[bucketIndex];
        if (list == null) return null;
        for (Entry<K, V> entry : list) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private int getBucketIndex(K key) {
        int index = (key.hashCode() & 0x7FFFFFFF) % capacity;
        return index;
    }

    //boolean get(K key, V value)
    public V get(K key) {
        //locate bucket index
        int bucketIndex = getBucketIndex(key);

        //search in the linkedlist
        Entry<K, V> entry = checkExistence(bucketIndex, key);
        return entry == null ? null : entry.value;
    }


    //V remove(Key k)
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> entry = checkExistence(bucketIndex, key);

        if (entry == null) {
            return null;
        } else {
            //remove
            LinkedList<Entry<K, V>> entries = table[bucketIndex];
            boolean remove = entries.remove(entry);
            capacity--;
            return entry.value;
        }
    }

    //boolean containsKey(K key)
    public boolean containsKey(K key) {
        int bucketIndex = getBucketIndex(key);
        Entry<K, V> entry = checkExistence(bucketIndex, key);
        return entry == null ? false : true;
    }


    //void resize();
    public void resize() {
        capacity = capacity << 2;

        LinkedList<Entry<K, V>>[] new_table = new LinkedList[capacity];
        //rehash and copy ele
        for (int i = 0; i < table.length; i++) {
            LinkedList<Entry<K, V>> list = table[i];
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    int bucketIndex = getBucketIndex(entry.key);
                    LinkedList<Entry<K, V>> bucket = new_table[bucketIndex];
                    if (bucket == null) new_table[bucketIndex] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }
            }
            //help GC
            table[i].clear();
            table[i]=null;
        }

        table = new_table;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> e : table[i]) {
                    values.add(e.value);
                }
            }
        }
        return values;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i = 0; i < table.length; i++) {
            for (Entry<K, V> entry : table[i]) {
                builder.append("entry:" + entry + ",");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    //not sure how to implement as not familiar with iterator working mechanism
    @Override
    public java.util.Iterator<K> iterator() {

        return new java.util.Iterator<K>() {
            int bucketIndex = 0;
            java.util.Iterator<Entry<K, V>> bucketIterator = table[0] == null ? null : table[0].iterator();

            @Override
            public boolean hasNext() {
                if (bucketIterator == null || !bucketIterator.hasNext()) {
                    while (++bucketIndex < capacity) {
                        bucketIterator = table[bucketIndex].iterator();
                        break;
                    }
                }

                return bucketIndex<capacity;
            }

            @Override
            public K next() {
                return bucketIterator.next().key;
            }
        };
    }

    class Entry<K, V> {
        int hash;
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        public boolean equals(Entry e) {
            if (e.hash != hash) return false;
            return key.equals(e.key);
        }

        public String toString() {
            return key + "=>" + value;
        }

    }
}
