package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumKnightMoves {
    private static int[][] directions= new int[][]{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};

    public static void main(String[] args) {
        minKnightMoves(1,1);
    }
    public static int minKnightMoves(int x, int y) {
        x=Math.abs(x);
        y=Math.abs(y);

        LinkedList<int[]> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.add(new int[]{0,0});
        visited.add("0,0");
        int layer=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] cur=queue.poll();
                if(cur[0]==x&&cur[1]==y) return layer++;
                for(int[] dir:directions){
                    if(cur[0]+dir[0]>=-1&&cur[1]+dir[1]>=-1&&visited.add(cur[0]+dir[0]+","+(cur[1]+dir[1])))queue.add(new int[]{cur[0]+dir[0],cur[1]+dir[1]});
                }
            }
            layer++;
        }
        return -1;
    }
}
