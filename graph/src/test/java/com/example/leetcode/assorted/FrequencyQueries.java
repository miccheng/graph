package com.example.leetcode.assorted;

import org.assertj.core.util.Lists;

import java.util.*;

public class FrequencyQueries {
    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(3, 4);
        List<Integer> list2 = Lists.newArrayList(2, 1003);
        List<Integer> list3 = Lists.newArrayList(1, 16);
        List<Integer> list4 = Lists.newArrayList(3, 1);
        List<List<Integer>> list = Lists.newArrayList(list1, list2, list3, list4);
        freqQuery(list);
    }

    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();//val--> fre
        Map<Integer, Integer> invertedMap = new HashMap<>();//fre--> count of the number at k fre
        for (List<Integer> operation : queries) {
            Integer type = operation.get(0);
            Integer value = operation.get(1);
            switch (type) {
                case 1:// insert: map2--,map++;map2++
                    int fre = map.getOrDefault(value, 0);
                    if (fre != 0) invertedMap.put(fre, invertedMap.get(fre) - 1);
                    map.put(value, fre + 1);
                    invertedMap.put(fre + 1, invertedMap.getOrDefault(fre + 1, 0) + 1);
                    break;
                case 2:// delete: map2++,map--,map2--
                    if (map.isEmpty() || !map.containsKey(value) || map.get(value) == 0) continue;
                    int fre2 = map.get(value);
                    if (fre2 != 0) invertedMap.put(fre2, invertedMap.get(fre2) - 1);
                    map.put(value, fre2 - 1);
                    if (fre2 - 1 != 0) invertedMap.put(fre2 - 1, invertedMap.getOrDefault(fre2 - 1,0) + 1);
                    break;
                case 3:// operation.get(0)==3
                    //    long count=map.isEmpty()?0l:map.entrySet().stream().filter(e->e.getValue()==value).count();
                    // boolean flag=map.isEmpty()?false:map.containsValue(value);
                    if (!invertedMap.isEmpty() && invertedMap.containsKey(value)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }

        }
        return result;
    }

    static List<Integer> freqQuery2(List<List<Integer>> queries) {
        HashMap<Integer, Integer> valuesToCounts = new HashMap<>();
        HashMap<Integer, Set<Integer>> countsToValues = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();
        int size = queries.size();

        for(List<Integer> operations: queries){
            int operation = operations.get(0);
            int number = operations.get(1);

            int oldCount = valuesToCounts.getOrDefault(number, 0);
            int newCount;

            if (operation == 1) {
                newCount = oldCount + 1;
                valuesToCounts.put(number, newCount);

                if (countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }
                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if (operation == 2) {
                newCount = (oldCount > 1) ? oldCount - 1 : 0;
                valuesToCounts.put(number, newCount);

                if (countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }

                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if (operation == 3) {
                if (number > size) results.add(0);
                else {
                    results.add((number == 0 || countsToValues.getOrDefault(number, Collections.emptySet()).size() > 0) ? 1 : 0);
                }
            }
        }

        return results;
    }


}
