package com.example.leetcode.graph;

import org.assertj.core.util.Lists;

import java.util.*;

//***topological sort for DAG(has to be DAG to apply topological sort)
//1. top sort is not unique. 2.DAG will at least have one top sort 3.always start with node with 0 incoming vertices
public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        findOrderI(numCourses,prerequisites);
    }
    //use list to construct graph
    public static int[] findOrderI(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = Lists.newArrayList();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int [] arr:prerequisites) {
            graph.get(arr[1]).add(arr[0]);
        }
        //use hashmap to store status, 0 -> unvisited, 1 -> processing, 2 -> visited
        Map<Integer, Integer> track = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            track.put(i, 0);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if (!topSort(i, graph, track, result)) return new int[0];
        }
        //*****have to reverse the list
        Collections.reverse(result);
        int[] ints = result.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    private static boolean topSort(int i, List<List<Integer>> graph, Map<Integer, Integer> map, List<Integer> result) {
        //base case
        if(map.get(i)==1) return false;//has cycle
        if(map.get(i)==2) return true;//

        //body
        map.put(i,1);
        List<Integer> adj = graph.get(i);
        for (int ad:adj) {
            if(!topSort(ad,graph,map,result)) return false;
        }
        result.add(i);
        map.put(i,2);
        return  true;
    }


    //only for checking cycle. can't use it for ordered result
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] arr:prerequisites) {
            List<Integer> list = map.get(arr[1]);
            if (list == null) list = new ArrayList<Integer>();
            list.add(arr[0]);
            map.put(arr[1], list);
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();//tracking for processing
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            dfs(map, key, result, set);
        }
        int[] ints = result.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    private static boolean dfs(Map<Integer, List<Integer>> map,Integer node, List<Integer> result, Set<Integer> set) {
        if (set.contains(node)) return true;//has cycle
        if (!map.containsKey(node)||map.get(node).size() == 0) {
            result.add(node);
            return false;
        }

        set.add(node);
        List<Integer> adjecents = map.get(node);
        for (int adj : adjecents) {
            if (dfs(map, adj, result, set)) return false;
        }
        //******don't forget to reset and collect result
        set.remove(node);
        result.add(node);
        return false;
    }


}
