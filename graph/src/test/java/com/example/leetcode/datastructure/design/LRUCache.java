package com.example.leetcode.datastructure.design;

import java.util.HashMap;
import java.util.Map;

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
            add(o);
            return o.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {//updating and shift the node by removing and add
        if (map.containsKey(key)) remove(map.get(key));
        if (map.size() == cache_capcity) remove(tail.prev);//check capacity
        add(new Node(key, value));
    }

    private void add(Node node){
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
}
