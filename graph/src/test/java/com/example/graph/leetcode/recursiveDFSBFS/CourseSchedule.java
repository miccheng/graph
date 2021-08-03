package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.*;

//** no need to visit each node in the graph--> cache the true result
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0) return true;

        Map <Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){//Initialise it with empty
            map.putIfAbsent(i, new ArrayList<Integer>());
        }

        buildGraph(prerequisites,map);
        return search(map,numCourses);
    }

    private void buildGraph(int[][] prerequisites, Map<Integer, List<Integer>> map){
        for(int[] course: prerequisites ){
            map.get(course[1]).add(course[0]);
        }
    }

    private boolean search(Map<Integer, List<Integer>> map,int numCourses){
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,map,new HashSet<Integer>())) return false;
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map,Set<Integer> visiting ){
        if(visiting.contains(course)) return false;
        if(map.get(course)==null||map.get(course).isEmpty()) return true;

        List<Integer> preconditions=map.get(course);
        visiting.add(course);

        for(int precourse:preconditions){
            if(!dfs(precourse, map, visiting)) return false;
        }
        visiting.remove(course);
        map.put(course, new ArrayList<>());//memo the true result
        return true;
    }

}
