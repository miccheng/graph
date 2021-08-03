package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.*;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1=sentence1.length;
        int len2=sentence2.length;
        if(len1!=len2) return false;
        //****
        if(Arrays.equals(sentence1,sentence2)) return true;

        Map<String, Set<String>> map=new HashMap<>();
        for(List<String> pair:similarPairs){
            map.putIfAbsent(pair.get(0), new HashSet<String>());
            map.putIfAbsent(pair.get(1), new HashSet<String>());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for(int i=0;i<len1;i++){
            String s1=sentence1[i];
            String s2=sentence2[i];
            if(s1.equals(s2)) continue;
            if(!map.containsKey(s1)||!map.containsKey(s2)) return false;
            if(!map.get(s1).contains(s2)||!map.get(s2).contains(s1)) return false;
        }
        return true;
    }
}
