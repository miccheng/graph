package com.exanple.leetcode.datastructure.design;

public class MyHashSet <E> {
    private static final int default_capacity = 1 << 4;
    private HandMade<E, Object> map = new HandMade();
    private final Object DUMMY = new Object();

    //constructor
    public MyHashSet() {
        this(default_capacity);
    }

    public MyHashSet(int capacity) {
        map = new HandMade<>(capacity);
    }

    //int getSize()
    public int getSize() {
        return map.getSize();
    }

    //boolean isEmpty()
    public boolean isEmpty() {
        return map.isEmpty();
    }

    //boolean add(E key)
    public boolean add(E key) {
        return map.put(key, DUMMY) == null;
    }

    //remove(E key)
    public boolean remove(E key) {
        return map.remove(key) == null;
    }


    //boolean contains()
    public boolean contains(E key) {
        return map.containsKey(key);
    }


//    public java.util.Iterator<E> iterator() {
//        return map.keySet().iterator();
//    }

    //clear()
    public void clear() {
        map.clear();
    }


    @Override
    public String toString() {
        return "MyHashSet{" +
                "map=" + map +
                ", DUMMY=" + DUMMY +
                '}';
    }
}
