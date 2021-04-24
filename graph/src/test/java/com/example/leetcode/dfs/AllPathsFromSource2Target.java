package com.example.leetcode.dfs;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPathsFromSource2Target {
    public static void main(String[] args) {
        int [][] graph = {{4,3,1},{3,2,4},{},{4},{}};
        allPathsSourceTarget(graph);
    }
    
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graphh = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            graphh.add(new ArrayList<>());
        }
        int i=0;
        for (int [] arr :graph) {
            List<Integer> collect = IntStream.of(arr).boxed().collect(Collectors.toList());
            graphh.get(i).addAll(collect);
            i++;
        }

        //start from index 0
        dfs(0,new ArrayList<>(),result, graphh,graph.length-1);

        return result;
    }

    private static void dfs(int start, List<Integer> list, List<List<Integer>> result, List<List<Integer>> graphh, int length) {
        list.add(start);
        List<Integer> candidates = graphh.get(start);
        if(start ==length ){
            result.add(new ArrayList<>(list));
            return;
        }

        if( candidates.isEmpty()) return;

        for (Integer candidate:candidates) {
            List<Integer> path = new ArrayList<>(list);
            dfs(candidate, path, result, graphh,length);
            path.remove(path.size()-1);
        }
    }
}
