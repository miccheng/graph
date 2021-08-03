package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.*;

public class CourseScheduleII {
    List<Integer> result=new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int i=0;i<numCourses;i++){////Initialise it with empty
            graph.putIfAbsent(i, new ArrayList<Integer>());
        }
        buildGraph(graph,prerequisites);

        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            Set<Integer> visiting=new HashSet<Integer> ();
            if(dfs(graph,i,visiting,visited)==false) return new int[]{};
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(Map<Integer, List<Integer>>  graph,int course, Set<Integer> visiting, Set<Integer> visited ){
        if(visiting.contains(course)) return false;
        if(visited.contains(course)) return true;

        visiting.add(course);

        for(Integer prereq:graph.get(course)){
            if(dfs(graph,prereq,visiting,visited)==false) return false;
        }
        visiting.remove(course);
        visited.add(course);
        result.add(course);
        return true;
    }

    private void buildGraph( Map<Integer, List<Integer>> graph, int[][] prerequisites){
        for(int courses[] :prerequisites){
            int course=courses[0];
            int dependency=courses[1];
            graph.get(course).add(dependency);
        }
    }
}
