package com.example.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPathsFromSource2Target {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {}, {4}, {}};
        allPathsSourceTarget(graph);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> grids = new ArrayList<>();

        for (int[] arr : graph) {
            grids.add(arr);
        }
        int end = graph.length - 1;

        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(grids, 0, end, path, result);
        return result;
    }

    private static void dfs(List<int[]> grids, int start, int end, List<Integer> path, List<List<Integer>> result) {
        if (start == end) {
            result.add(new ArrayList<>(path));
            return;//must stop
        }

        for (Integer cur : grids.get(start)) {
            path.add(cur);
            dfs(grids, cur, end, path, result);
            path.remove(cur);//****must remove
        }

    }

}
