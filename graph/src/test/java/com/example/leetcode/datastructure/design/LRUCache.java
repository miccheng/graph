package com.example.leetcode.datastructure.design;

import java.util.HashMap;
import java.util.Map;
//Solution 1: always append new ele to head, so that the old value is always the closest to tail. and remove always the ele pre tail
public class LRUCache {
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    int cache_capcity;
    Map<Integer,Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        cache_capcity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {//after get, shift has to happen. So remove and adda new one
        if (map.containsKey(key)) {
            Node o = map.get(key);
            remove(o);
            insert(o);
            return o.value;
        } else {
            return -1;
        }
    }
    //must check if it contains and remove if found
    public void put(int key, int value) {//updating and shift the node by removing and add
        if (map.containsKey(key)) remove(map.get(key));
        if (map.size() == cache_capcity) remove(tail.prev);//check capacity
        insert(new Node(key, value));
    }

    //***adjust the pointers correctly
    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next=node;
        node.prev=head;

        node.next=headNext;
        headNext.prev=node;
    }

    private  void remove(Node node){
        map.remove(node.key);
        Node next = node.next;
        Node prev = node.prev;
        prev.next=next;
        next.prev=prev;
    }


    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    //Solution 2: use linked hashmap
//    private LinkedHashMap<Integer, Integer> map;
//    private final int CAPACITY;
//    public LRUCache(int capacity) {
//        CAPACITY = capacity;
//        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
//            protected boolean removeEldestEntry(Map.Entry eldest) {
//                return size() > CAPACITY;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return map.getOrDefault(key, -1);
//    }
//    public void set(int key, int value) {
//        map.put(key, value);
//    }
}
