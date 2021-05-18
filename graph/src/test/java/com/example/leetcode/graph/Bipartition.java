package com.example.leetcode.greedy.dfs;

import java.util.*;

//graph colouring. dfs /bfs
//double direction graph
public class Bipartition {
    public static void main(String[] args) {
        int n = 5;
        int [][]dislikes = {{1,2},{1,3},{2,3}};
        possibleBipartition(n,dislikes);
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int dis[]:dislikes) {//****double  directions
            graph.get(dis[0]).add(dis[1]);
            graph.get(dis[1]).add(dis[0]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n+1; i++) {
            map.put(i,-1);
        }

        for (int i = 0; i < graph.size(); i++) {
            int colour=1;
            if(map.get(i)==-1 && !dfs(i,graph,map, colour)) return false;
        }
        return true;
    }

    private static boolean dfs(int i, List<List<Integer>> graph,Map<Integer, Integer> map, int colour) {
        if (map.get(i)!= -1) return map.get(i) == colour;

        //colour the current node
        map.put(i,colour);
        List<Integer> connections = graph.get(i);
        for (Integer ii : connections) {
           if(!dfs(ii, graph, map, 1 - colour)) return false;//if return false, have to return false
        }
        return true;
    }



}
