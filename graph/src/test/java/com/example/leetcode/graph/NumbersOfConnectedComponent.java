package com.example.leetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class NumbersOfConnectedComponent {
    //union find
    public static void main(String[] args) {
        int[][] input = {{0, 1}, {1, 2}, {3, 4}};
    }

    public int countComponents(int n, int[][] edges) {
        int graph[] = new int[n];
        //initially each one is its own set
        for (int i = 0; i < n; i++) graph[i] = i;

        for (int[] edge : edges) {
            unionSet(edge[0], edge[1], graph);
        }

        //store parent node
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            set.add(findParent(i, graph));
        }

        return set.size();
    }

    private void unionSet(int edge1, int edge2, int[] graph) {
        int i = findParent(edge1, graph);
        int parent = findParent(edge2, graph);
        graph[i] = parent;
    }


    private Integer findParent(int i, int[] graph) {
        //path compression
        if (graph[i] != i) graph[i] = findParent(i, graph);
        return graph[i];
    }


}
