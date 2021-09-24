package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBipartite {
    public static void main(String[] args) {
        int[][] re = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        isBipartite(re);
    }

    public static boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        int[] colors = new int[graph.length];
        for (int nums[] : graph) {
            for (int i : nums) {
                if (colors[i] != 0 && dfs(i, colors, graph, 1) == false) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int colors[], int[][] graph, int tocolor) {
        if (colors[i] != 0) return colors[i] == tocolor;
        colors[i] = tocolor;
        for (int negh : graph[i]) {
            if (dfs(negh, colors, graph, 0 - tocolor) == false) return false;
        }
        return true;
    }
}
