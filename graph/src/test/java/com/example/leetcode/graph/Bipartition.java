package com.example.leetcode.graph;

import java.util.*;

//graph colouring. dfs /bfs
//Undirected graph
public class Bipartition {

    public boolean isBipartite(int[][] graph) {
        if(graph==null||graph.length==0) return true;
        int n=graph.length;
        Map<Integer, Integer> map=new HashMap<>();//i->color
        for(int i=0;i<n;i++){
            if(!map.containsKey(i)){
                if(!dfs(i,1, graph, map)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i,int colour, int[][] graph,Map<Integer, Integer> map){
        if(map.containsKey(i)) return map.get(i)==colour;

        map.put(i, colour);
        for(int j=0;j<graph[i].length;j++){
            if(!dfs(graph[i][j], 0-colour, graph, map)) return false;
        }
        return true;
    }


}
