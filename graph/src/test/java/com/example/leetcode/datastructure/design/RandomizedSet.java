package com.example.leetcode.datastructure.design;

import java.util.*;

//Insert Delete GetRandom O(1)
public class RandomizedSet {
    //***map.key=the actual value stored. The key is its index in the arrayList
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map=new HashMap();
        list=new ArrayList<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    //***swap with last ele in the list and remove always the last ele
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastEle = list.get(list.size() - 1);
        list.set(index, lastEle);//***override the to be removed val
        list.remove(list.size() - 1);
        map.put(lastEle, index);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = random.nextInt(list.size());//exclusive
        return list.get(i);
    }
}
