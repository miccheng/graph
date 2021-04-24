package com.example.leetcode.recursivedp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//m = { "a": 1, "b": { "c": 2, "d": [3,4] } }
//What we need to do is flattening this JSON structure, only keeping one layer of combined-keys and values. For example, for the above input, the output is supposed to be
//o = {"a": 1, "b.c": 2, "b.d": [3,4] }
public class FlattenMap {
    public static void main(String args[]) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> nestedMap = new HashMap<>();
        HashMap<String, Object> innerMap = new HashMap<>();

        innerMap.put("c", "2");
        innerMap.put("d", "34");
        nestedMap.put("i",innerMap);
        map.put("a", "1");
        map.put("b", nestedMap);

        recursive(map);
    }

    public static Map recursive(Map<String, Object> map) {
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                Map<String, String> map2 = recursive((Map) value);
                Map<String, String> map3 = map2.entrySet().stream()
                        .collect(Collectors.toMap(e -> key + "." + e.getKey(), e -> e.getValue()));
                resultMap.putAll(map3);
            } else {
                resultMap.put(key, (String) value);
            }
        }
        return resultMap;
    }

    public static Map<String, Object> flatMap(Map<String, Object> map) {
        HashMap<String, Object> resultMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                Map<String, Object> map1 = flatMap((Map<String, Object>) value);
                map1.entrySet().stream().collect(Collectors.toMap(e -> key + "." + e.getKey(), e -> e.getValue()));
//                for (String ele : map.keySet()) {
//                    resultMap.put(key +"."+ ele, map1.get(ele));
//                }
            } else {//base case
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}
