package com.example.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class LargestTreesInForest {
    public static void main(String[] args) {
        int n = 5;
        int edges[][] = {{0, 3}, {3, 5}, {3, 1}, {4, 0}, {4, 2}};
        int max=0;
        largestTree(edges,n,max);
    }

    private static void largestTree(int[][] edges, int n,int max) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int arr[] : edges) {
            graph.get(arr[0]).add(arr[1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            dfs(graph, i, new ArrayList<Integer>(),result);
        }
        List<Integer> integers = result.stream().max((a, b) -> a.size() - b.size()).get();
        System.out.println();
        
    }

    private static void dfs(List<List<Integer>> graph, int i, List<Integer> path, List<List<Integer>> result) {
        path.add(i);

        if (graph.get(i).isEmpty()) {
            result.add(new ArrayList<>(path));
            return;
        }


        List<Integer> adjs = graph.get(i);
        for (int adj : adjs) {
            dfs(graph, adj, path, result);
            path.remove(path.size()-1);
        }

    }
}
