package com.example.graph.leetcode.recursiveDFSBFS;

import org.assertj.core.util.Lists;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        List<String> eq1=Lists.newArrayList("a","b");
        List<String> eq2=Lists.newArrayList("b","c");
        List<List<String>> eq = new ArrayList<>();
        eq.add(eq1);
        eq.add(eq2);
        double[] values={2.0,3.0};
        List<String> query1 = Lists.newArrayList("a", "c");
        List<String> query2 = Lists.newArrayList("b", "a");
        List<String> query3 = Lists.newArrayList("a","e");
        List<String> query4 = Lists.newArrayList("a","a");
        List<String> query5 = Lists.newArrayList("x","x");
        List<List<String>> queries=new ArrayList<>();
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);
        calcEquation(eq,values,queries);
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> map=new HashMap<>();
        buildGraph(map,equations,values);

        List<Double> result=new ArrayList<>();
        for(List<String> query: queries){
            result.add(dfs(query.get(0),query.get(1),1, map, new HashSet<>()));
        }

        return result.stream().mapToDouble(Double::intValue).toArray();
    }

    private static double dfs(String origin, String dest,double product, Map<String, List<Pair>> map,HashSet<String> set){
        if(set.contains(origin)||!map.containsKey(origin)){
            return -1.0;
        }
        if(origin.equals(dest)){
            return product;
        }

        set.add(origin);
        List<Pair> pairs=map.get(origin);
        for(Pair p: pairs){
            double res=dfs(p.str,dest, product*p.val,map, set);
            if(res!=-1.0) return res;
        }
        set.remove(origin);
        return -1.0;
    }

    private static void buildGraph(Map<String, List<Pair>> map,List<List<String>> equations,double[] values){
        for(int i=0;i<equations.size();i++){
            List<String> eq=equations.get(i);
            map.putIfAbsent(eq.get(0), new ArrayList<>());
            map.putIfAbsent(eq.get(1), new ArrayList<>());
            map.get(eq.get(0)).add(new Pair(eq.get(1),values[i]));
            map.get(eq.get(1)).add(new Pair(eq.get(0),1.0/values[i]));
        }
    }


    static class Pair{
        String str;
        double val;
        public Pair(String s, double val){
            this.str=s;
            this.val=val;
        }
    }
}
