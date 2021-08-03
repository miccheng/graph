package com.example.graph.leetcode.recursiveDFSBFS;

import org.assertj.core.util.Lists;

import java.util.*;

public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int len1=sentence1.length;
        int len2=sentence2.length;
        if(len1!=len2) return false;
        if(Arrays.equals(sentence1,sentence2)) return true;

        Map<String, Set<String>> graph=new HashMap<>();
        buildGraph(similarPairs, graph);


        for(int i=0;i<len1;i++){
            if(sentence1[i].equals(sentence2[i])){
                continue;
            }else if(!graph.containsKey(sentence1[i])){//***must check
                return false;
            }else{
                Set<String> visited=new HashSet<>();
                if(dfs(sentence1[i],sentence2[i], graph,visited)==false) return false;
            }
        }
        return true;
    }

    private boolean dfs(String s1, String s2, Map <String, Set<String>> graph, Set<String> visited){
        if(s1.equals(s2)) return true;

        visited.add(s1);
        Set<String> negibhours=graph.get(s1);
        for(String nghor: negibhours){
            if(!visited.contains(nghor)){
                if(dfs(nghor,s2,graph, visited)) return true;
            }
        }
        return false;
    }

    private static void buildGraph(List<List<String>> similarPairs, Map<String, Set<String>> graph){
        for(List<String> pair: similarPairs){
            graph.putIfAbsent(pair.get(0), new HashSet<String>());
            graph.putIfAbsent(pair.get(1), new HashSet<String>());
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }
    }
}
