package com.example.graph.leetcode.recursiveDFSBFS;

import java.util.HashSet;
import java.util.Set;

public class DetectCyclesIn2DGrid {
    static Set<String> visited=new HashSet<>();
    static int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
       char[][] grid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        containsCycle(grid);
    }

    public static boolean containsCycle(char[][] grid) {
        if(grid==null||grid.length==0) return false;
        int row=grid.length;
        int col=grid[0].length;


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited.contains(i+","+j)) {
                    if(dfs(i,j,i,j, grid, new HashSet<>())) return true;;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int startX, int startY, int i, int j,char[][] grid, Set<String> visiting ){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=grid[startX][startY]) return false;
        if(startX==i&&startY==j &&visiting.size()>0) return true;

        visited.add(i+","+j);
        visiting.add(i+","+j);
        for(int [] dir: directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (!visiting.contains(x + "," + y) && dfs(startX, startY, x, y, grid, visiting)) return true;
        }
        return false;
    }
}
